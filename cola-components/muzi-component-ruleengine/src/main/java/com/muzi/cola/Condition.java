package com.muzi.cola;

public interface Condition {

    boolean evaluate(Facts facts);

    default Condition and(Condition condition){
        return (facts -> this.evaluate(facts) && condition.evaluate(facts));
    }

    default Condition or(Condition condition){
        return (facts -> this.evaluate(facts) || condition.evaluate(facts));
    }
}
