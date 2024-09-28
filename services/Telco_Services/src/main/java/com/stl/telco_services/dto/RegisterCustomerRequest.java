package com.stl.telco_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterCustomerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String NIC;
    private String password;
}
