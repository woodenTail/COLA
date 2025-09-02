package com.muzi.cola;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ApplicationContextHelper.class)
    public ApplicationContextHelper initApplicationContentHelper(){
        return new ApplicationContextHelper();
    }
}
