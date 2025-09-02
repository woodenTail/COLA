package com.muzi.cola;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 多坐标测试
 *
 * @author wangguoqiang wrote on 2022/10/10 14:54
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MultiCoordinateTests {


    @Resource
    private ExtensionExecutor extensionExecutor;


    @Test
    public void testMultiCoordinate() {
        BizScenario bizScenario = BizScenario.onlyScenario("china");

        extensionExecutor.execute(CustomerAddExt.class, bizScenario, (t) -> {
            Customer customer = new Customer();
            customer.setCustomerId("1");
            customer.setCompanyName("木子企业");
            customer.setSource("1");
            t.addCustomer(customer);
            return null;
        });
    }

}
