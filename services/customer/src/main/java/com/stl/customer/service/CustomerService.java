package com.stl.customer.service;

import com.stl.customer.dto.request.CustomerRequest;
import com.stl.customer.entity.Customer;
import com.stl.customer.exception.UserNotFoundException;
import com.stl.customer.mapper.CustomerMapper;
import com.stl.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public Long createCustomer(CustomerRequest request) {
        var customer = this.repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public Customer getCustomer(String nic) {
        Customer customer = this.repository.findByNIC(nic).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
        return customer;
    }
//    public String createCustomer(@Valid CustomerRequest request) {
//
//    }
}
