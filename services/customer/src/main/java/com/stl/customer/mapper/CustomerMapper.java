package com.stl.customer.mapper;

import com.stl.customer.dto.request.CustomerRequest;
import com.stl.customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .NIC(request.NIC())
                .password(request.password())
                .build();
    }
}
