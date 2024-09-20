package com.stl.telco_services.controller;

import com.stl.telco_services.entity.Rate;
import com.stl.telco_services.service.TelcoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/telco")
@RequiredArgsConstructor
public class Telco {

    @Autowired
    private final TelcoService service;

    @GetMapping("/{nic}")
    public ResponseEntity<Object> getCustomerDetails(@PathVariable("nic") String nic){
        System.out.println(nic);
        return ResponseEntity.ok(this.service.getCutomerDetails(nic));
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllPackages(){
        return ResponseEntity.ok(this.service.getAllPackages());
    }

//    @PostMapping("/dataAddOn")
//    public ResponseEntity<Object> dataAddOn(@RequestBody DataAddOnRequest dataAddOnRequest){
//        return ResponseEntity.ok(this.service.dataAddOn(dataAddOnRequest));
//    }
}
