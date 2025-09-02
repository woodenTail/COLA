package com.muzi.cola;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExtensionRepository {

    public Map<ExtensionCoordinate, ExtensionPointI> extensionMap = new HashMap<>();

    public Map<ExtensionCoordinate, ExtensionPointI> getExtensionMap(){
        return extensionMap;
    }
}
