package com.stl.telco_services.controller;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.RegisterServiceRequest;
import com.stl.telco_services.dto.SubscribeServiceRequest;
import com.stl.telco_services.dto.UnsubscribeServiceRequest;
import com.stl.telco_services.entity.TelcoService;
import com.stl.telco_services.service.ServiceService;
import com.stl.telco_services.service.ServiceSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sri-tel/api/v1/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceSubscriptionService serviceSubscriptionService;

    @PostMapping("/add")
    public AnyResponse addTelcoService(@RequestBody RegisterServiceRequest service) {
        return serviceService.addService(service);
    }

    @PostMapping("/subscribe")
    public AnyResponse subscribeTelcoService(@RequestBody SubscribeServiceRequest service) {
        return serviceSubscriptionService.subscribeService(service);
    }

    @PostMapping("/unsubscribe")
    public AnyResponse unsubscribeTelcoService(@RequestBody UnsubscribeServiceRequest service) {
        return serviceSubscriptionService.unsubscribeService(service);
    }

    @GetMapping("/viewSubscribedServices/{id}")
    public AnyResponse viewSubscribedServices(@PathVariable long id) {
        return serviceSubscriptionService.viewSubscribedServices(id);
    }

    @GetMapping("/viewAll")
    public List<TelcoService> viewTelcoService() {
        return serviceService.getAllServices();
    }
}
