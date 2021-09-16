package com.chujian.mytest.activity;

import com.chujian.ups.annotator.ViewInjectProcessor;

import java.lang.reflect.Method;

public class BBKnife {
    // 调用我们生成的辅助类
    public static void bind(Object view){
        try {
            String cla = view.getClass().getName()+ ViewInjectProcessor.SUFFIX;
            Class clazz = Class.forName(cla);
            Object instance = clazz.newInstance();
            Method bind = clazz.getMethod("bind",Object.class);
            bind.invoke(instance,view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
