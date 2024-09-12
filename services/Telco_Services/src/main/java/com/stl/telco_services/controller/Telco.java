package com.stl.telco_services.controller;

import com.stl.telco_services.customer.NicRequest;
import com.stl.telco_services.entity.Package;
import com.stl.telco_services.service.TelcoService;
import jakarta.ws.rs.Path;
import lombok.Getter;
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
        System.out.println("Telco get customer " + nic);
        return ResponseEntity.ok(this.service.getCutomerDetails(nic));
    }
}
