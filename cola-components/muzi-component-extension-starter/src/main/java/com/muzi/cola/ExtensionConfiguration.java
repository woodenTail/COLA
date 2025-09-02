package com.muzi.cola;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExtensionConfiguration {

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    public ExtensionRegister register(){
        return new ExtensionRegister();
    }

    @ConditionalOnMissingBean
    public ExtensionRepository repository(){
        return new ExtensionRepository();
    }
}
