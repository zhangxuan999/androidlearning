package com.chujian.ups.annotator;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import static javax.lang.model.element.ElementKind.CLASS;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.STATIC;

/**
 * Created by 政魁 on 2019/1/17 17:05
 * E-Mail Address：wangzhengkui@yingzi.com
 */
@AutoService(Processor.class)
public class WzkBinderProcessor extends AbstractProcessor {
    private Types typeUtils;
    private Elements elementUtils;
    private Filer filer;
    private Messager messager;

    private Map<String, BindingSet> mActivities = new HashMap<>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        
        //该方法会被注解处理工具调用，其中的processingEnvironment中会提供很多有用的类：Elements, Types and Filer
        typeUtils = processingEnvironment.getTypeUtils();
        elementUtils = processingEnvironment.getElementUtils();
        filer = processingEnvironment.getFiler();
        messager = processingEnvironment.getMessager();
        log("zhangxuan init");

    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        log("zhangxuan process");
        //该方法相当于java应用程序的main()方法。这里会扫描、编译、处理我们的自定义的注解
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BinderView.class);
        System.out.println(elements.size());
        for (Element element : elements) {
            System.out.println(element.toString() + "," + element.getAnnotation(BinderView.class).value());
            // Start by verifying common generated code restrictions.
            isInaccessibleViaGeneratedCode(BinderView.class, "fields", element);
            //拿到该变量所在的class，在这里就是activity了
            TypeElement activity = ((TypeElement) element.getEnclosingElement());

            System.out.println(activity.getQualifiedName());
            //查找该activity的bind文件是否存在，如果存在，则直接取出TypeSpec;
            String bindActivityClassName = activity.getSimpleName() + "ViewBinding";
            String fileKey = getPackageName(element) + "." + bindActivityClassName;
           BindingSet bindingSet;
            if (mActivities.containsKey(fileKey)) {
                bindingSet = mActivities.get(fileKey);
            } else {
                bindingSet = new BindingSet(bindActivityClassName, activity);
                mActivities.put(fileKey, bindingSet);
            }
            bindingSet.addBindView(element);
        }

        //准备生成代码文件
        generatorClassName();
        return false;
    }

    private void generatorClassName() {
        try {
            Iterator<Map.Entry<String, BindingSet>> iterator = mActivities.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, BindingSet> specEntry = iterator.next();
                String packageName = specEntry.getKey().substring(0, specEntry.getKey().lastIndexOf("."));
                //先新建文件
                JavaFile javaFile = JavaFile.builder(packageName, specEntry.getValue().generatorCode())
                        .addFileComment("Generated code from Butter Knife. Do not modify!")
                        .build();
                javaFile.writeTo(filer);
            }

        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    private String getPackageName(Element element) {
        return elementUtils.getPackageOf(element).getQualifiedName().toString();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //返回该注解处理程序能够处理的注解。
        return Collections.singleton(BinderView.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        //支持的版本。默认为返回SourceVersion.latestSupported()
//        return super.getSupportedSourceVersion();
        return SourceVersion.latestSupported();
    }

    private boolean isInaccessibleViaGeneratedCode(Class<? extends Annotation> annotationClass,
                                                   String targetThing, Element element) {
        boolean hasError = false;
        TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();

        // Verify field or method modifiers.
        Set<Modifier> modifiers = element.getModifiers();
        if (modifiers.contains(PRIVATE) || modifiers.contains(STATIC)) {
            error(element, "@%s %s must not be private or static. (%s.%s)",
                    annotationClass.getSimpleName(), targetThing, enclosingElement.getQualifiedName(),
                    element.getSimpleName());
            hasError = true;
        }

        // Verify containing type.
        if (enclosingElement.getKind() != CLASS) {
            error(enclosingElement, "@%s %s may only be contained in classes. (%s.%s)",
                    annotationClass.getSimpleName(), targetThing, enclosingElement.getQualifiedName(),
                    element.getSimpleName());
            hasError = true;
        }

        // Verify containing class visibility is not private.
        if (enclosingElement.getModifiers().contains(PRIVATE)) {
            error(enclosingElement, "@%s %s may not be contained in private classes. (%s.%s)",
                    annotationClass.getSimpleName(), targetThing, enclosingElement.getQualifiedName(),
                    element.getSimpleName());
            hasError = true;
        }

        return hasError;
    }

    private void error(Element e, String msg, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
    }

    private void log(String msg) {
        messager.printMessage(Diagnostic.Kind.WARNING, msg);
    }
}
