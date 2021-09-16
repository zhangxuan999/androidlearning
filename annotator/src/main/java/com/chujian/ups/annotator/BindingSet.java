package com.chujian.ups.annotator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Created by 政魁 on 2019/1/18 14:35
 * E-Mail Address：wangzhengkui@yingzi.com
 */
public class BindingSet {
    List<Element> mBindViews = new ArrayList<>();
    String mClassName;
    TypeElement mActivityElement;

    public BindingSet(String className, TypeElement typeElement) {
        this.mClassName = className;
        this.mActivityElement = typeElement;
    }

    public void addBindView(Element bindView) {
        mBindViews.add(bindView);
    }

    /**
     * 使用javapoet来生成代码
     * @return
     */
    public TypeSpec generatorCode() {
        //类名称
        TypeSpec.Builder builder = TypeSpec.classBuilder(mClassName)
                .addModifiers(Modifier.PUBLIC);
        //添加静态的bindView方法
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("bindView")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(ClassName.get(mActivityElement), "target");
        //将Activity中的添加了BinderView注解的变量赋值。
        for (Element bindView : mBindViews) {
            methodBuilder.addStatement(String.format(Locale.CHINESE,
                    "target.%s = target.findViewById(%d)", bindView.getSimpleName(), bindView.getAnnotation(BinderView.class).value()));
        }

        builder.addMethod(methodBuilder.build());
        return builder.build();
    }
}
