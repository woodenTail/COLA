package com.muzi.cola;

import javax.swing.*;

public class SpelRuleBuilder {

    String conditionExpression;

    Action action;


    public SpelRuleBuilder when(String conditionExpression) {
        this.conditionExpression = conditionExpression;
        return this;
    }

    public SpelRuleBuilder then(Action action) {
        this.action = action;
        return this;
    }

    public  Rule build() {
        return new SpelRule(this.conditionExpression,  this.action);
    }
}
