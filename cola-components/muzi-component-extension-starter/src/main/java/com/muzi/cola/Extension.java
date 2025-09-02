package com.muzi.cola;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Component
public @interface Extension {

    String bizId() default BizScenario.DEFAULT_BIZID;

    String useCase() default BizScenario.DEFAULT_USE_CASE;


    String scenario() default BizScenario.DEFALUT_SCENARIO;
}
