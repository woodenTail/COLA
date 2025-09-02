package com.muzi.cola;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelRuleEngine implements RuleEngine {
    ExpressionParser parser = new SpelExpressionParser();

    @Override
    public void fire(Rule rule, Facts facts) {

        StandardEvaluationContext context = new StandardEvaluationContext(facts);
        context.setVariable("facts", facts);

        if(rule instanceof SpelRule) {
            SpelRule spelRule = (SpelRule) rule;
            Expression expression = parser.parseExpression(spelRule.conditionExpression);
            if(expression.getValue(context) == Boolean.TRUE) {
                rule.execute(facts);
            }
        }
    }
}
