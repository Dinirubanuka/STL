package com.stl.customer.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (
        Long id,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "Customer firstname is required")
        String lastname,
        @NotNull(message = "Customer Email is required")
        @NotNull(message = "NIC cannot be empty")
        String NIC,
        @NotNull(message = "Mobile number cant be empty")
        String mobileNumber
        //password and confirm password validation done by the font end
){
}
