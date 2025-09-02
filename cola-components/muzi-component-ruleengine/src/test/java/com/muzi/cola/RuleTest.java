package com.muzi.cola;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;


public class RuleTest {


    @Test
    public void ruleTest() {
        Facts facts = new Facts();
        facts.add(new Fact<>("isVip", true));
        facts.add(new Fact<>("age", 18));
        facts.add(new Fact<>("orderAmount", 200));


        // 创建规则1: 如果年龄大于18且是VIP，则提供折扣
        RuleBuilder builder = new RuleBuilder();
        Rule rule = builder.when(ConditionBuilder.and(t -> t.get("isVip") == Boolean.TRUE, t -> (Integer) t.get("age") >= 18))
                .then(t -> System.out.println("Rule 1: " + "年龄大于18且是VIP，则提供折扣"))
                .build();
        RuleEngine  engine = new DefaultRuleEngine();
        engine.fire(rule, facts);


        // 创建规则2: 如果订单金额超过100，则提供免费配送
    }

    @Test
    public void spElRuleTest() {
        ExpressionParser parser = new SpelExpressionParser();
        Facts facts = new Facts();
        facts.add(new Fact<>("isVip", true));
        facts.add(new Fact<>("age", 18));
        facts.add(new Fact<>("orderAmount", 200));


        StandardEvaluationContext context = new StandardEvaluationContext(facts);
        context.setVariable("facts", facts);

        String conditionExpression = "#facts.get('isVip') and #facts.get('age')>=18";
//        Expression expression = parser.parseExpression(conditionExpression);
//        Object value = expression.getValue(context);
//        System.out.println(value);
        Rule rule = new SpelRule(conditionExpression,
                t-> System.out.println("Rule 2: " + "年龄大于18且是VIP，则提供折扣"));
        RuleEngine  engine = new SpelRuleEngine();
        engine.fire(rule, facts);
    }

    @Test
    public void test(){


        RuleBuilder builder = new RuleBuilder();
        User user = new User();
        user.setName("Muzi");
        user.setAge(18);
        user.setSex("女");
        user.setHeight(1.7);
        user.setWeight(100);

        Fact<User> userFact = new Fact<>(user);
        Facts facts = new Facts();
        facts.add(userFact);

        builder.when(fs-> {
            AtomicBoolean result = new AtomicBoolean(false);
                    fs.forEach(fact -> {

                        Fact u = (Fact) fact;

                        result.set(((User)u.getValue()).getAge() >= 18);
                    });
                    return result.get();
                })
                .then(facts1-> {
                    facts1.forEach(fact -> {
                        Fact f = (Fact) fact;
                        User u = (User)f.getValue();
                        System.out.println(u.getName()+":该嫁人了");
                    });
                });

        boolean evaluate = builder.condition.evaluate(facts);
        if (evaluate){
            builder.action.execute(facts);
        }


        Condition  condition = new Condition() {
            @Override
            public boolean evaluate(Facts facts) {
                AtomicBoolean result = new AtomicBoolean(false);
                facts.forEach(fact -> {
                    Fact f = (Fact) fact;
                    User u = (User)f.getValue();
                    result.set(u.getAge() >= 18);
                });
                return result.get();
            }
        };
        Action  action = new Action() {
            @Override
            public void execute(Facts f) {
                f.forEach(fact -> {
                    Fact f1 = (Fact) fact;
                    User u = (User)f1.getValue();
                    System.out.println(u.getName()+":该嫁人了");
                });
            }
        };
        RuleBuilder builder2 = new RuleBuilder();
        builder2.when(condition).then(action);
        boolean evaluate1 = builder2.condition.evaluate(facts);
        if (evaluate1){
            builder2.action.execute(facts);
        }

    }


}
