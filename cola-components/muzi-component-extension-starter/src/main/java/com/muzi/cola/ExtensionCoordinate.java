package com.muzi.cola;

public class ExtensionCoordinate {

    Class<? extends ExtensionPointI> target;
    BizScenario scenario;

    public ExtensionCoordinate(Class<? extends ExtensionPointI> target, BizScenario scenario) {
        this.target = target;
        this.scenario = scenario;
    }

    public Class<? extends ExtensionPointI> getTarget() {
        return target;
    }

    public void setTarget(Class<? extends ExtensionPointI> target) {
        this.target = target;
    }

    public BizScenario getScenario() {
        return scenario;
    }

    public void setScenario(BizScenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + (target==null?0:target.hashCode());
        result = 31 * result + scenario.getUniqueId().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        ExtensionCoordinate extensionCoordinate = (ExtensionCoordinate) obj;

        if(target == null && extensionCoordinate.target != null){
            return false;
        }
        if(extensionCoordinate.target == null && target != null){
            return false;
        }
        if(target == null){
            return scenario.getUniqueId().equals(extensionCoordinate.scenario.getUniqueId());
        }
        return target.getName().equals(extensionCoordinate.getTarget().getName()) &&
                scenario.getUniqueId().equals(extensionCoordinate.scenario.getUniqueId());
    }
}
