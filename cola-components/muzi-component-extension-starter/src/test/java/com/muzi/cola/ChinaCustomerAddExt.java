package com.muzi.cola;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Extension(scenario = "china")
public class ChinaCustomerAddExt implements CustomerAddExt{
    private static final Logger log = LoggerFactory.getLogger(ChinaCustomerAddExt.class);

    @Override
    public void addCustomer(Customer customer) {
        log.info("china add customer");

    }
}
