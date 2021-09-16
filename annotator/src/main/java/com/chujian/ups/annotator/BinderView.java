package com.chujian.ups.annotator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by 政魁 on 2019/1/17 17:13
 * E-Mail Address：wangzhengkui@yingzi.com
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface BinderView {
    /**
     * View ID to which the field will be bound.
     */
    int value() default 0;
}
