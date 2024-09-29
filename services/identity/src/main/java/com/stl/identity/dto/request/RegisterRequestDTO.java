package com.stl.identity.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    private String firstname;
    private String lastname;
    @NotNull
    @NotNull
    private String email;
    @NotNull
    @NotNull
    private String NIC;
    @NotNull
    @NotNull
    private String password;
    @NotNull
    @NotBlank
    private String mobileNumber;
}
