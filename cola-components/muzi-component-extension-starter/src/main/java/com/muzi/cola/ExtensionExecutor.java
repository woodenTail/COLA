package com.muzi.cola;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.function.Function;

@Component
public class ExtensionExecutor {

    @Resource
    ExtensionRepository extensionRepository;

    public <T extends ExtensionPointI, R> R execute(Class<T> targetClass, BizScenario bizScenario, Function<T, R> function) {
        ExtensionCoordinate coordinate = new ExtensionCoordinate(targetClass, bizScenario);
        T extensionPointI = (T)extensionRepository.getExtensionMap().get(coordinate);
        return function.apply(extensionPointI);
    }
}
