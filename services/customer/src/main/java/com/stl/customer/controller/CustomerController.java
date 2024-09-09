package com.stl.customer.controller;

import com.stl.customer.entity.Customer;
import com.stl.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok(this.service.createCustomer(request));
    }

    @GetMapping
    public ResponseEntity<Customer> getCustomer(@RequestBody String NIC) {
        return ResponseEntity.ok(this.service.getCustomer(NIC));
    }


}
