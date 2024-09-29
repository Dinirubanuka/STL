package com.stl.telco_services.controller;

import com.stl.telco_services.dto.*;
import com.stl.telco_services.entity.TelcoPackage;
import com.stl.telco_services.service.PackageActivationService;
import com.stl.telco_services.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/telco/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;
    @Autowired
    private PackageActivationService packageActivationService;

    @PostMapping("/add")
    public AnyResponse addTelcoPackage(@RequestBody RegisterPackageRequest tel_package) {
        System.out.println("HERE I AM");
        return packageService.addPackage(tel_package);
    }

    @PostMapping("/activate")
    public AnyResponse activateTelcoPackage(@RequestBody ActivatePackageRequest request) {
        return packageActivationService.activatePackage(request);
    }

    @PostMapping("/deactivate")
    public AnyResponse deactivateTelcoPackage(@RequestBody DeactivatePackageRequest request) {
        return packageActivationService.deactivatePackage(request);
    }

    @GetMapping("/viewActivePackages/{id}")
    public AnyResponse viewActivePackages(@PathVariable long id) {
        return packageActivationService.viewActivePackages(id);
    }

    @GetMapping("/viewAll")
    public List<TelcoPackage> viewTelcoPackage() {
        return packageService.getAllPackages();
    }

}
