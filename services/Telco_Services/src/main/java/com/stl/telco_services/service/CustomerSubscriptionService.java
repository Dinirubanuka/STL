package com.stl.telco_services.service;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.CreateSubscriptionRequest;
import com.stl.telco_services.dto.TopupRequest;
import com.stl.telco_services.entity.Customer;
import com.stl.telco_services.entity.CustomerSubscription;
import com.stl.telco_services.repository.CustomerRepo;
import com.stl.telco_services.repository.CustomerSubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CustomerSubscriptionService {
    @Autowired
    private CustomerSubscriptionRepo customerSubscriptionRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AnyResponse anyResponse;

    public AnyResponse subscribe(CreateSubscriptionRequest request) {
        Customer customer = customerRepo.findById(request.getCustomerId()).orElse(null);

        if (customer == null) {
            anyResponse.setMessage("Customer not found");
            anyResponse.setData(null);
            return anyResponse;
        }

        Timestamp subscribedDateTime = new Timestamp(System.currentTimeMillis());

        CustomerSubscription customerSubscription = new CustomerSubscription();
        customerSubscription.setCustomer(customer);
        customerSubscription.setBasePackage(request.getBasePackage());
        customerSubscription.setSubscriptionDateTime(subscribedDateTime);
        customerSubscription.setPhone(request.getPhone());
        customerSubscription.setPayType(request.getPayType());
        customerSubscription.setDataBalance(0);
        customerSubscription.setVoiceBalance(0);
        customerSubscription.setCreditBalance(0);
        customerSubscription.setOutstandingAmount(0);

        customerSubscriptionRepo.save(customerSubscription);

        anyResponse.setMessage("Customer successfully subscribed");
        anyResponse.setData(customerSubscription);
        return anyResponse;

    }

    public AnyResponse unsubscribe(CustomerSubscription customerSubscription) {
        customerSubscriptionRepo.delete(customerSubscription);
        anyResponse.setMessage("Customer successfully unsubscribed");
        anyResponse.setData(customerSubscription);
        return anyResponse;
    }

    public CustomerSubscription findCustomerSubscriptionById(long customerId) {
        CustomerSubscription customerSubscription = customerSubscriptionRepo.findByCustomerId(customerId).orElse(null);
        return customerSubscription;
    }

    public AnyResponse topUpCreditBalance(TopupRequest request) {
        CustomerSubscription customerSubscription = customerSubscriptionRepo.findByCustomerId(request.getCustomerId()).orElse(null);
        if (customerSubscription == null) {
            anyResponse.setMessage("No subscription found for the customer");
            anyResponse.setData(null);
            return anyResponse;
        }
        customerSubscription.setCreditBalance(customerSubscription.getCreditBalance() + request.getAmount());
        customerSubscriptionRepo.save(customerSubscription);
        anyResponse.setMessage("Credit balance successfully updated");
        anyResponse.setData(customerSubscription);
        return anyResponse;
    }

    public AnyResponse topUpVoiceBalance(TopupRequest request) {
        CustomerSubscription customerSubscription = customerSubscriptionRepo.findByCustomerId(request.getCustomerId()).orElse(null);
        if (customerSubscription == null) {
            anyResponse.setMessage("No subscription found for the customer");
            anyResponse.setData(null);
            return anyResponse;
        }

        customerSubscription.setVoiceBalance(customerSubscription.getVoiceBalance() + request.getAmount());
        customerSubscriptionRepo.save(customerSubscription);
        anyResponse.setMessage("Voice balance successfully updated");
        anyResponse.setData(customerSubscription);
        return anyResponse;
    }

    public AnyResponse topUpDataBalance(TopupRequest request) {
        CustomerSubscription customerSubscription = customerSubscriptionRepo.findByCustomerId(request.getCustomerId()).orElse(null);
        if (customerSubscription == null) {
            anyResponse.setMessage("No subscription found for the customer");
            anyResponse.setData(null);
            return anyResponse;
        }
        customerSubscription.setDataBalance(customerSubscription.getDataBalance() + request.getAmount());
        customerSubscriptionRepo.save(customerSubscription);
        anyResponse.setMessage("Data balance successfully updated");
        anyResponse.setData(customerSubscription);
        return anyResponse;
    }

}
