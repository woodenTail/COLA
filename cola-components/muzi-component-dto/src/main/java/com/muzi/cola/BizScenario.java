package com.muzi.cola;

public class BizScenario {

    public static final String DEFALUT_SCENARIO = "defualt_scenario";
    public static final String DEFAULT_BIZID = "biz_id";
    public static final String DEFAULT_USE_CASE = "use_case";

    String bizId;
    String useCase;
    String scenario;

    public BizScenario() {
    }

    public BizScenario(String bizId, String useCase, String scenario) {
        this.bizId = bizId;
        this.useCase = useCase;
        this.scenario = scenario;
    }


    public   String getUniqueId() {
        return this.bizId+this.scenario+this.scenario;
    }

    public static BizScenario getScenario(String bizId, String userCase, String scenarioStr) {
        BizScenario scenario = new BizScenario();
        scenario.bizId = bizId;
        scenario.useCase = userCase;
        scenario.scenario = scenarioStr;
        return scenario;
    }

    public static BizScenario onlyScenario(String scenario) {
        BizScenario bizScenario = new BizScenario();
        bizScenario.valueOf(DEFAULT_BIZID,DEFAULT_USE_CASE,scenario);
        return bizScenario;
    }

    public static BizScenario onlyBiz(String bizId) {
        BizScenario bizScenario = new BizScenario();
        bizScenario.valueOf(bizId,DEFAULT_USE_CASE,DEFALUT_SCENARIO);
        return bizScenario;
    }

    public void valueOf(String bizId, String useCase, String scenario) {
        this.bizId = bizId;
        this.useCase = useCase;
        this.scenario = scenario;
    }


}
