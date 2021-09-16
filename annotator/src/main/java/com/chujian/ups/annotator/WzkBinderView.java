package com.chujian.ups.annotator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 政魁 on 2019/1/18 16:47
 * E-Mail Address：wangzhengkui@yingzi.com
 */
public class WzkBinderView {
    public static void bind(Object activity) {
        try {
            //使用反射，获取activity对应的ActivityViewBinding文件，在反射调用bind()方法;
            Class<?> targetClass = Class.forName(activity.getClass().getName()+"ViewBinding");
            Method classDeclaredMethod = targetClass.getDeclaredMethod("bindView", activity.getClass());
            classDeclaredMethod.invoke(targetClass, activity);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            if (cause instanceof Error) {
                throw (Error) cause;
            }
            throw new RuntimeException("Unable to create binding instance.", cause);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
