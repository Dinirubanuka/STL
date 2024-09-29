package com.stl.telco_services.controller;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.UpdateUsageRequest;
import com.stl.telco_services.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/telco/usage")
public class UsageController {
    @Autowired
    private UsageService usageService;

    @PostMapping("/use")
    public AnyResponse updateUsage(@RequestBody UpdateUsageRequest request) {
        return usageService.updateUsage(request);
    }
}
