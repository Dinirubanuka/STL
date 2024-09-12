package com.stl.telco_services.service;

import com.stl.telco_services.customer.CustomerDetails;
import com.stl.telco_services.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelcoService {
    private final PackageRepository repository;
    private final CustomerDetails customerDetails;

    public Object getCutomerDetails(String nic) {

        var customer =  customerDetails.getCustomer(nic);
        System.out.println(customer);
        return customer;
    }
}
