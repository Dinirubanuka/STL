package com.stl.telco_services.service;

import com.stl.telco_services.customer.CustomerDetails;
import com.stl.telco_services.entity.Rate;
import com.stl.telco_services.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelcoService {
    private final CustomerDetails customerDetails;
    private final RateRepository rateRepository;

    public Object getCutomerDetails(String nic) {

        var customer =  customerDetails.getCustomer(nic);
        System.out.println(customer);
        return customer;
    }

    public List<Rate> getAllPackages() {
        return rateRepository.findAll();
    }


//    public Object dataAddOn(DataAddOnRequest dataAddOnRequest) {
//
//    }
}
