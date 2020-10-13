package com.mmall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wucf
 * @description 用来标记课程中不安全的类
 * @date 2020-10-12 13:59
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//不在运行中显示
public @interface NotThreadSafe {
    String value() default "";
}