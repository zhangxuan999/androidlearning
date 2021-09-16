package com.chujian.ups.annotator;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.chujian.ups.annotator.BindView"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ViewInjectProcessor extends AbstractProcessor {


    /**
     * 用于将创建的类写入到文件
     */
    private Filer mFiler;
    Map<String, List<VariableInfo>> classMap = new HashMap<>();
    Map<String, TypeElement> classTypeElement = new HashMap<>();

    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//
//
//        collectInfo(roundEnvironment);
//        writeToFile();
//        return true;
//    }
//
//    void collectInfo(RoundEnvironment roundEnvironment) {
//        classMap.clear();
//        classTypeElement.clear();
//
//        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BindView.class);
//        for (Element element : elements) {
//            int viewId = element.getAnnotation(BindView.class).value();
//
//            VariableElement variableElement = (VariableElement) element;
//
//            TypeElement typeElement = (TypeElement) variableElement.getEnclosingElement();
//            String classFullName = typeElement.getQualifiedName().toString();
//
//            List<VariableInfo> variableList = classMap.get(classFullName);
//            if (variableList == null) {
//                variableList = new ArrayList<>();
//                classMap.put(classFullName, variableList);
//
//                classTypeElement.put(classFullName, typeElement);
//            }
//            VariableInfo variableInfo = new VariableInfo();
//            variableInfo.setVariableElement(variableElement);
//            variableInfo.setViewId(viewId);
//            variableList.add(variableInfo);
//        }
//    }
//
//    void writeToFile() {
//        try {
//            for (String classFullName : classMap.keySet()) {
//                TypeElement typeElement = classTypeElement.get(classFullName);
//
//                MethodSpec.Builder constructor = MethodSpec.constructorBuilder()
//                        .addModifiers(Modifier.PUBLIC)
//                        .addParameter(ParameterSpec.builder(TypeName.get(typeElement.asType()), "activity").build());
//                List<VariableInfo> variableList = classMap.get(classFullName);
//                for (VariableInfo variableInfo : variableList) {
//                    VariableElement variableElement = variableInfo.getVariableElement();
//                    String variableName = variableElement.getSimpleName().toString();
//                    String variableFullName = variableElement.asType().toString();
//                    constructor.addStatement("activity.$L=($L)activity.findViewById($L)", variableName, variableFullName, variableInfo.getViewId());
//                }
//
//                TypeSpec typeSpec = TypeSpec.classBuilder(typeElement.getSimpleName() + "$$ViewInjector")
//                        .addModifiers(Modifier.PUBLIC)
//                        .addMethod(constructor.build())
//                        .build();
//
////                String packageFullName = elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
//                String packageFullName = typeElement.getSimpleName().toString();
//                log("packageFullName = " + packageFullName);
//                JavaFile javaFile = JavaFile.builder(packageFullName, typeSpec)
//                        .build();
//                javaFile.writeTo(mFiler);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    @Override
    public boolean process(Set annotations, RoundEnvironment roundEnv) {
        HashMap<String,List<VariableElement>> map = new HashMap<>(); // key 是类名，value 是该类的注解元素
        for (Element element : roundEnv.getElementsAnnotatedWith(BindView.class)) {
            if (element == null || !(element instanceof VariableElement)) {
                continue;
            }
            VariableElement variableElement = (VariableElement) element;
            String className = element.getEnclosingElement().getSimpleName().toString();
            List variableElementList = map.get(className);
            if (variableElementList == null) {
                variableElementList = new ArrayList<>();
                map.put(className, variableElementList);
            }
            variableElementList.add(variableElement);
        }
log("zhangxuan test");
        generate(map);
        return true;
    }
    public static final String SUFFIX = "$ViewBinder";
    private void generate(HashMap<String,List<VariableElement>> map) {
        if (null == map || map.size() == 0) {
            return;
        }
        for (String className : map.keySet()) {
            List<VariableElement> variableElementList = map.get(className);
            if (variableElementList == null || variableElementList.size() <= 0) {
                continue;
            }
            String packageName = variableElementList.get(0).getEnclosingElement().getEnclosingElement().toString();
            StringBuilder builder = new StringBuilder()
                    .append("package ").append(packageName).append(";\n\n")
                    .append("public class ").append(className).append(SUFFIX).append("{\n") // open class
                    .append("    public void bind(Object target) {\n")
                    .append("        ").append(className).append(" activity = (").append(className).append(")target;\n");

            for (VariableElement variableElement : variableElementList) {
                BindView bindView = variableElement.getAnnotation(BindView.class);
                log(bindView.toString());
                builder.append("        activity.").append(variableElement.getSimpleName().toString()).append("=(").append(variableElement.asType()).append(")activity.findViewById(").append(bindView.value()).append(");\n");
            }
            builder.append("    }\n}\n");
            // write the file
            try {
                String bindViewClassName = packageName + "." + className + SUFFIX;
                JavaFileObject source = processingEnv.getFiler().createSourceFile(bindViewClassName);
                Writer writer = source.openWriter();
                writer.write(builder.toString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }


    private void log(String msg) {
        messager.printMessage(Diagnostic.Kind.WARNING, msg);
    }
}
