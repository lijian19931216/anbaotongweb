package com.anbaotong.aspect;

import java.lang.annotation.*;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-19
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Paginate {
    String value() default "";
}
