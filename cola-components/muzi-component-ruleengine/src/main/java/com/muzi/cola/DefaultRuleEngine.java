package com.muzi.cola;

public class DefaultRuleEngine implements RuleEngine {
    @Override
    public void fire(Rule rule, Facts facts) {

        rule.apply(facts);
    }
}
