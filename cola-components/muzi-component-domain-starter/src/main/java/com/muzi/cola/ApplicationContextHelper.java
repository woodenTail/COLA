package com.muzi.cola;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        T beanInstance = null;
        beanInstance = applicationContext.getBean(clazz);
        if(beanInstance == null) {
            String simpleName = clazz.getSimpleName();
            simpleName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
            beanInstance = (T) applicationContext.getBean(simpleName);
        }
        return beanInstance;
    }
}
