package com.alibaba.demo.customer;

import com.alibaba.demo.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper{

  CustomerDO getById(String customerId);

    void save(CustomerDO customer);
}
