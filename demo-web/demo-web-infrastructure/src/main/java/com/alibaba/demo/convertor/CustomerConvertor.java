package com.alibaba.demo.convertor;

import com.alibaba.demo.customer.CustomerDO;
import com.alibaba.demo.domain.customer.Customer;
import com.alibaba.demo.dto.data.CustomerDTO;

public class CustomerConvertor {

    public static Customer convertAs(CustomerDTO from) {
        Customer to = new Customer();
        to.setCustomerId(from.getCustomerId());
        to.setMemberId(from.getMemberId());
        to.setCompanyName(from.getCompanyName());

        // Not mapped TO fields:
        // globalId
        // registeredCapital
        // source
        // companyType

        // Not mapped FROM fields:
        // customerName
        // customerType
        // source
        return to;
    }


    public static CustomerDO convertAs(Customer from) {
        CustomerDO to = new CustomerDO();
        to.setCustomerId(from.getCustomerId());
        to.setMemberId(from.getMemberId());
        to.setGlobalId(from.getGlobalId());
        to.setRegisteredCapital(from.getRegisteredCapital());
        to.setCompanyName(from.getCompanyName());

        // Not mapped FROM fields:
        // source
        // companyType
        return to;
    }
}
