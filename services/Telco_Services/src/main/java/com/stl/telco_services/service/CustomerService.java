package com.stl.telco_services.service;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.RegisterCustomerRequest;
import com.stl.telco_services.entity.Customer;
import com.stl.telco_services.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AnyResponse anyResponse;

    @Autowired
    private ModelMapper modelMapper;

    public AnyResponse addCustomer(RegisterCustomerRequest customer) {
        try {
            Customer newCustomer = customerRepo.save(modelMapper.map(customer, Customer.class));
            anyResponse.setMessage("Customer saved successfully");
            anyResponse.setData(newCustomer);
            return anyResponse;
        } catch (Exception e) {
            anyResponse.setMessage("Error in saving data " + e.getMessage());
            anyResponse.setData(null);
            return anyResponse;
        }
    }
}
