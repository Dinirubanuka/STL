package com.stl.telco_services.service;

import com.stl.telco_services.dto.ActivatePackageRequest;
import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.DeactivatePackageRequest;
import com.stl.telco_services.dto.UpdateUsageRequest;
import com.stl.telco_services.entity.*;
import com.stl.telco_services.repository.CustomerRepo;
import com.stl.telco_services.repository.CustomerSubscriptionRepo;
import com.stl.telco_services.repository.PackageActivationRepo;
import com.stl.telco_services.repository.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PackageActivationService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private CustomerSubscriptionRepo customerSubscriptionRepo;

    @Autowired
    private PackageActivationRepo packageActivationRepo;

    @Autowired
    private AnyResponse anyResponse;

    public AnyResponse activatePackage(ActivatePackageRequest request) {
        Customer customer = customerRepo.findById(request.getCustomerId()).orElse(null);
        TelcoPackage telcoPackage = packageRepo.findById(request.getPackageId()).orElse(null);
        CustomerSubscription customerSubscription = customerSubscriptionRepo.findByCustomerId(request.getCustomerId()).orElse(null);

        if(customer != null && telcoPackage != null && customerSubscription != null) {

            int customer_credit_balance = customerSubscription.getCreditBalance();
            float package_price = telcoPackage.getPrice();

            if(customer_credit_balance < package_price){
                anyResponse.setMessage("Not enough credit");
                anyResponse.setData(customerSubscription.getCreditBalance());
                return anyResponse;
            }

            // Deducting package price from customer
            customerSubscription.setCreditBalance((int) (customer_credit_balance - package_price));
            customerSubscriptionRepo.save(customerSubscription);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            PackageActivation packageActivationRecord = new PackageActivation();
            packageActivationRecord.setCustomer(customer);
            packageActivationRecord.setTelcoPackage(telcoPackage);
            packageActivationRecord.setActivationDateTime(timestamp);
            packageActivationRecord.setStatus(Status.ACTIVE);

            packageActivationRepo.save(packageActivationRecord);

            switch (telcoPackage.getServiceType()) {
                case VOICE:
                    customerSubscription.setVoiceBalance(telcoPackage.getSize());
                    break;

                case DATA:
                    customerSubscription.setDataBalance(telcoPackage.getSize());
                    break;
            }

            customerSubscriptionRepo.save(customerSubscription);

            anyResponse.setMessage("Package Successfully Activated");
            anyResponse.setData(packageActivationRecord);
            return anyResponse;

        }else{
            if(customer == null){
                anyResponse.setMessage("Customer not found");
            } else if (telcoPackage == null) {
                anyResponse.setMessage("Package not found");
            } else{
                anyResponse.setMessage("Customer does not have an active Subscription");
            }
            anyResponse.setData(null);
            return anyResponse;
        }
    }

    public AnyResponse deactivatePackage(DeactivatePackageRequest request) {
        PackageActivation packageActivationRecord = packageActivationRepo.findById(request.getPackageActivationId()).orElse(null);

        if(packageActivationRecord != null){
            if(packageActivationRecord.getStatus() == Status.ACTIVE){
                packageActivationRecord.setStatus(Status.DEACTIVATED);
                packageActivationRepo.save(packageActivationRecord);
                anyResponse.setMessage("Package Successfully Deactivated");
                anyResponse.setData(packageActivationRecord);
                return anyResponse;
            }
            anyResponse.setMessage("Customer does not have an active Subscription");
            anyResponse.setData(null);
            return anyResponse;
        }
        anyResponse.setMessage("Package Subscription not found");
        anyResponse.setData(null);
        return anyResponse;
    }

    public PackageActivation updateRemaining(UpdateUsageRequest request) {
        PackageActivation packageActivationRecord = packageActivationRepo.findById(request.getPackageActivationId()).orElse(null);
        if(packageActivationRecord != null){
            if(packageActivationRecord.getStatus() == Status.ACTIVE){
                if(packageActivationRecord.getRemaining() - request.getUsage() > 0) {
                    packageActivationRecord.setRemaining(packageActivationRecord.getRemaining() - request.getUsage());
                }else{
                    packageActivationRecord.setRemaining(0);
                    packageActivationRecord.setStatus(Status.DEACTIVATED);
                }
            }else{
                return null;
            }
            return packageActivationRecord;
        }
        return null;
    }

    public AnyResponse viewActivePackages(long user_id){
        List<PackageActivation> activePackagesList = packageActivationRepo.findAllByCustomerId(user_id).orElse(null);
        if(activePackagesList == null){
            anyResponse.setMessage("No active packages found");
            anyResponse.setData(null);
            return anyResponse;
        }
        anyResponse.setMessage("Active packages found");
        anyResponse.setData(activePackagesList);
        return anyResponse;
    }


}
