package com.stl.customer.controller;

import com.stl.customer.dto.request.CustomerRequest;
import com.stl.customer.dto.response.ApiResponse;
import com.stl.customer.entity.Customer;
import com.stl.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        ApiResponse<Long> response = new ApiResponse<>(HttpStatus.CREATED.value(),this.service.createCustomer(request),"success") ;
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> testController(){
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK.value(),"THIS IS A TEST","success"),HttpStatus.OK);
    }

    @GetMapping("/{nic}")
    public ResponseEntity<ApiResponse<Customer>> getCustomer(@PathVariable String nic) {
        System.out.println(nic);
        ApiResponse<Customer> response = new ApiResponse<>(HttpStatus.OK.value(),this.service.getCustomer(nic),"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
