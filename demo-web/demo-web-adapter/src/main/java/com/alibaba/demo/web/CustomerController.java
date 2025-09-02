package com.alibaba.demo.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.demo.api.CustomerServiceI;
import com.alibaba.demo.dto.CustomerAddCmd;
import com.alibaba.demo.dto.CustomerListByNameQry;
import com.alibaba.demo.dto.data.CustomerDTO;
import com.muzi.cola.ApplicationContextHelper;
import com.muzi.cola.catchlog.CatchLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CatchLog
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestParam(required = false) String name){
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @PostMapping(value = "/addCustomer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        ApplicationContextHelper.getBean(CustomerServiceI.class).addCustomer(customerAddCmd);
        return customerService.addCustomer(customerAddCmd);
    }
}
