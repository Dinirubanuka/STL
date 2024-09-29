package com.stl.telco_services.controller;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.CreateSubscriptionRequest;
import com.stl.telco_services.dto.TopupRequest;
import com.stl.telco_services.entity.CustomerSubscription;
import com.stl.telco_services.service.CustomerSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/telco/customer-subscription")
public class CustomerSubscriptionController {

    @Autowired
    private CustomerSubscriptionService customerSubscriptionService;

    @PostMapping("/subscribe")
    public AnyResponse subscribe(@RequestBody CreateSubscriptionRequest request) {
        return customerSubscriptionService.subscribe(request);
    }

    @PostMapping("/unsubscribe")
    public AnyResponse unsubscribe(@RequestBody CustomerSubscription subscription) {
        return customerSubscriptionService.unsubscribe(subscription);
    }

    @PostMapping("/creditTopUp")
    public AnyResponse topUpCreditBalance(@RequestBody TopupRequest request) {
        return customerSubscriptionService.topUpCreditBalance(request);
    }

    @PostMapping("/voiceTopUp")
    public AnyResponse topUpVoiceBalance(@RequestBody TopupRequest request) {
        return customerSubscriptionService.topUpVoiceBalance(request);
    }

    @PostMapping("/dataTopUp")
    public AnyResponse topUpDataBalance(@RequestBody TopupRequest request) {
        return customerSubscriptionService.topUpDataBalance(request);
    }

    @GetMapping("/view/{id}")
    public CustomerSubscription viewCustomerSubscription(@PathVariable Long id) {
        return customerSubscriptionService.findCustomerSubscriptionById(id);
    }

}
