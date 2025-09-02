package com.muzi.cola;

public class RuleBuilder {

    Condition condition;

    Action action;

    public RuleBuilder() {}

    public RuleBuilder when(Condition condition) {
        this.condition = condition;
        return this;
    }

    public RuleBuilder then(Action action) {
        this.action = action;
        return this;
    }

    public  Rule build() {
        return new DefaultRule(this.condition, this.action);
    }
}
