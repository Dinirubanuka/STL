package com.stl.telco_services.controller;


import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.RegisterCustomerRequest;
import com.stl.telco_services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sri-tel/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public AnyResponse addCustomer(@RequestBody RegisterCustomerRequest customer) {
        return customerService.addCustomer(customer);
    }

}
