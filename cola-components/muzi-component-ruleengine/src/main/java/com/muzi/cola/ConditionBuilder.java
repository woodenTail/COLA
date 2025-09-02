package com.muzi.cola;

public class ConditionBuilder {


    public static Condition and(Condition ... conditions){
        Condition condition = conditions[0];
        for(Condition c : conditions){
            condition.and(c);
        }
        return condition;
    }
    public static Condition or(Condition ... conditions){
        Condition condition = conditions[0];
        for(Condition c : conditions){
            condition.or(c);
        }
        return condition;
    }
}
