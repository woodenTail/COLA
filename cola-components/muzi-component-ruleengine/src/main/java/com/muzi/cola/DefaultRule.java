package com.muzi.cola;

public class DefaultRule implements Rule{

    private Condition condition;
    private Action action;

    public DefaultRule(Condition condition, Action action) {
        this.condition = condition;
        this.action = action;
    }

    @Override
    public boolean evaluate(Facts facts) {
        return condition.evaluate(facts);
    }

    @Override
    public void execute(Facts facts) {
        action.execute(facts);
    }

    @Override
    public void apply(Facts facts) {
        if (condition.evaluate(facts)){
            action.execute(facts);
        }
    }
}
