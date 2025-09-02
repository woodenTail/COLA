package com.muzi.cola;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExtensionRegister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Resource
    ExtensionRepository extensionResponsity;

    public final static String EXTENSION_EXTPT_NAMING = "Ext";

    @PostConstruct
    public void init(){
        Map<String, Object> extensionMap =
                applicationContext.getBeansWithAnnotation(Extension.class);
        if(!extensionMap.isEmpty()){
            extensionMap.forEach((k,v)->{

                ExtensionPointI extension = (ExtensionPointI) v;
                Extension annotation = extension.getClass().getAnnotation(Extension.class);
                BizScenario scenario = BizScenario.getScenario(annotation.bizId(), annotation.useCase(), annotation.scenario());
                Class<?> interfaceClass = getInterfaceClass(extension);
                ExtensionCoordinate coordinate = new ExtensionCoordinate((Class<? extends ExtensionPointI>) interfaceClass, scenario);
                extensionResponsity.getExtensionMap().put(coordinate, extension);
            });
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    private Class<? > getInterfaceClass(ExtensionPointI targetClz) {
        Class<?>[] interfaces = ClassUtils.getAllInterfacesForClass(targetClz.getClass());
        if(interfaces.length == 0){
            return targetClz.getClass();
        }
        if(interfaces.length == 1){
            return   interfaces[0];
        }
        for (Class<?> intf : interfaces) {
            String extensionPoint = intf.getSimpleName();
            if (extensionPoint.contains(EXTENSION_EXTPT_NAMING)) {
                return intf;
            }
        }
        return null;
    }




}
