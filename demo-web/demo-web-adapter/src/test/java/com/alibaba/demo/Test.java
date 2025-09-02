package com.alibaba.demo;

import com.alibaba.demo.dto.CustomerAddCmd;
import com.alibaba.fastjson.JSON;
import org.jeasy.random.EasyRandom;

import static org.mockito.Mockito.mock;

public class Test {

    public static void main(String[] args) {
        EasyRandom easyRandom = new EasyRandom();
        CustomerAddCmd cmd = easyRandom.nextObject(CustomerAddCmd.class);
        System.out.println(JSON.toJSONString(cmd));

    }
}
