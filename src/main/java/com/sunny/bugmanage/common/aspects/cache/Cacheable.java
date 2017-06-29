package com.sunny.bugmanage.common.aspects.cache;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.aspects.cache.Cacheable
 * @date 2017-06-26 10:40
 * @description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {
    
    @AliasFor("cacheNames")
    String value() default "";
    
    @AliasFor("value")
    String cacheNames() default "";

    String key();
}
