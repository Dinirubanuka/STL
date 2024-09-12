package com.stl.telco_services.controller;

import com.stl.telco_services.service.TelcoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/telco")
@RequiredArgsConstructor
public class Telco {

    @Autowired
    private final TelcoService service;

    @GetMapping("/{nic}")
    public ResponseEntity<Object> getCustomerDetails(@PathVariable("nic") String nic){
        return ResponseEntity.ok(this.service.getCutomerDetails(nic));
    }

//    @GetMapping
//    public ResponseEntity<Object> getAllPackages(){
//
//
//
//    }

//    @PostMapping("/dataAddOn")
//    public ResponseEntity<Object> dataAddOn(@RequestBody DataAddOnRequest dataAddOnRequest){
//        return ResponseEntity.ok(this.service.dataAddOn(dataAddOnRequest));
//    }
}
