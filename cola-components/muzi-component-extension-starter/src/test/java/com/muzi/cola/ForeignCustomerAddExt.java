package com.muzi.cola;


import com.alibaba.cola.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension(scenario = "foreign")
public class ForeignCustomerAddExt implements CustomerAddExt {

    private static final Logger log = LoggerFactory.getLogger(ForeignCustomerAddExt.class);

    public void addCustomer(Customer customer) {
        if(!customer.isBigCompany()){
            throw  new BizException("外资企业注册资金不符合标准");
        }
        log.info("foreign add customer");
    }
}
