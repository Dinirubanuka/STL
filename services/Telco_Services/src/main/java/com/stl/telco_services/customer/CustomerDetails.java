package com.stl.telco_services.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerDetails {
    @GetMapping("/{nic}")
    Object getCustomer(@PathVariable("nic") String nic);
}
