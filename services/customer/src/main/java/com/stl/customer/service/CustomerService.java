package com.stl.customer.service;

import com.stl.customer.controller.CustomerRequest;
import com.stl.customer.entity.Customer;
import com.stl.customer.exception.UserNotFoundException;
import com.stl.customer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        var customer = this.repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public Customer getCustomer(String nic) {
        Customer customer = this.repository.findById(nic).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
        return customer;
    }
//    public String createCustomer(@Valid CustomerRequest request) {
//
//    }
}
