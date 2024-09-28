package com.stl.telco_services.service;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.SubscribeServiceRequest;
import com.stl.telco_services.dto.UnsubscribeServiceRequest;
import com.stl.telco_services.entity.*;
import com.stl.telco_services.entity.TelcoService;
import com.stl.telco_services.repository.CustomerRepo;
import com.stl.telco_services.repository.CustomerSubscriptionRepo;
import com.stl.telco_services.repository.ServiceRepo;
import com.stl.telco_services.repository.ServiceSubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ServiceSubscriptionService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private ServiceSubscriptionRepo serviceSubscriptionRepo;

    @Autowired
    private AnyResponse anyResponse;
    @Autowired
    private CustomerSubscriptionRepo customerSubscriptionRepo;

    public AnyResponse subscribeService(SubscribeServiceRequest request) {
        Customer customer = customerRepo.findById(request.getCustomerId()).orElse(null);
        TelcoService telcoService = serviceRepo.findById(request.getServiceId()).orElse(null);

        if (customer != null && telcoService != null) {
            if(telcoService.getStatus() == Status.DEACTIVATED){
                anyResponse.setMessage("Service is not active at the moment");
                anyResponse.setData(null);
                return anyResponse;
            }

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            ServiceSubscription serviceSubscription = new ServiceSubscription();
            serviceSubscription.setCustomer(customer);
            serviceSubscription.setTelcoService(telcoService);
            serviceSubscription.setStatus(Status.ACTIVE);
            serviceSubscription.setActivatedDateTime(timestamp);

            serviceSubscriptionRepo.save(serviceSubscription);

            anyResponse.setMessage("Subscribed to the Service");
            anyResponse.setData(serviceSubscription);
            return anyResponse;

        }else if (customer == null) {
            anyResponse.setMessage("Customer not found");
            anyResponse.setData(null);
            return anyResponse;
        }else{
            anyResponse.setMessage("Could not subscribe to the Service");
            anyResponse.setData(null);
            return anyResponse;
        }
    }

    public AnyResponse unsubscribeService(UnsubscribeServiceRequest request) {
        ServiceSubscription serviceSubscriptionRecord = serviceSubscriptionRepo.findById(request.getServiceSubscriptionId()).orElse(null);

        if (serviceSubscriptionRecord != null) {
            if(serviceSubscriptionRecord.getStatus() == Status.ACTIVE){
                serviceSubscriptionRecord.setStatus(Status.DEACTIVATED);

                serviceSubscriptionRepo.save(serviceSubscriptionRecord);
                anyResponse.setMessage("Service Successfully Unsubscribed");
                anyResponse.setData(serviceSubscriptionRecord);
                return anyResponse;
            }
            anyResponse.setMessage("Customer does not have an active Subscription");
            anyResponse.setData(null);
            return anyResponse;
        }
        anyResponse.setMessage("Service Subscription not found");
        anyResponse.setData(null);
        return anyResponse;
    }

    public AnyResponse viewSubscribedServices(long user_id){
        List<ServiceSubscription> subscribedServicesList = serviceSubscriptionRepo.findAllByCustomerId(user_id).orElse(null);
        if(subscribedServicesList == null){
            anyResponse.setMessage("No subscribed services found");
            anyResponse.setData(null);
            return anyResponse;
        }
        anyResponse.setMessage("Subscribed services found");
        anyResponse.setData(subscribedServicesList);
        return anyResponse;
    }

}
