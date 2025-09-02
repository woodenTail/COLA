package com.muzi.cola;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelRule implements Rule{
    String conditionExpression;
    Action action;

    ExpressionParser parser = new SpelExpressionParser();

    public SpelRule(String conditionExpression,  Action action) {
        this.conditionExpression = conditionExpression;
        this.action = action;
    }

    @Override
    public boolean evaluate(Facts facts) {
        return false;
    }

    @Override
    public void execute(Facts facts) {
        action.execute(facts);
    }

    @Override
    public void apply(Facts facts) {
        action.execute(facts);
    }


}
