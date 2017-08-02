package com.skxj.firstboot.dao;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Snow on 7/11/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface UsersMapper {
    String value() default "";
}
