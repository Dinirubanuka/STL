package com.stl.telco_services.service;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.UpdateUsageRequest;
import com.stl.telco_services.entity.*;
import com.stl.telco_services.repository.DataUsageRepo;
import com.stl.telco_services.repository.VoiceUsageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UsageService {
    @Autowired
    private VoiceUsageRepo voiceUsageRepo;

    @Autowired
    private DataUsageRepo dataUsageRepo;

    @Autowired
    private CustomerSubscriptionService customerSubscriptionService;

    @Autowired
    private PackageActivationService packageActivationService;

    @Autowired
    private AnyResponse anyResponse;

    public AnyResponse updateUsage(UpdateUsageRequest request) {
        PackageActivation packageActivation = packageActivationService.updateRemaining(request);
        if (packageActivation != null) {
            Customer customer = packageActivation.getCustomer();
            CustomerSubscription customerSubscription = customerSubscriptionService.findCustomerSubscriptionById(customer.getId());

            if (customerSubscription != null) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                switch (packageActivation.getTelcoPackage().getServiceType()){

                    case VOICE:
                        customerSubscription.setVoiceBalance(customerSubscription.getVoiceBalance() - request.getUsage());
                        VoiceUsage voiceUsage = new VoiceUsage();
                        voiceUsage.setActivation(packageActivation);
                        voiceUsage.setUsage(request.getUsage());
                        voiceUsage.setRecordDateTime(timestamp);
                        voiceUsageRepo.save(voiceUsage);
                        anyResponse.setMessage("Voice usage updated");
                        anyResponse.setData(voiceUsage);
                        break;

                    case DATA:
                        customerSubscription.setDataBalance(customerSubscription.getDataBalance() - request.getUsage());
                        DataUsage dataUsage = new DataUsage();
                        dataUsage.setActivation(packageActivation);
                        dataUsage.setUsage(request.getUsage());
                        dataUsage.setRecordDateTime(timestamp);
                        dataUsageRepo.save(dataUsage);
                        anyResponse.setMessage("Data usage updated");
                        anyResponse.setData(dataUsage);
                        break;
                }
                return anyResponse;
            }
            anyResponse.setMessage("No activation found");
            anyResponse.setData(null);
            return anyResponse;
        }
        anyResponse.setMessage("Package has been expired or not available");
        anyResponse.setData(null);
        return anyResponse;
    }



}
