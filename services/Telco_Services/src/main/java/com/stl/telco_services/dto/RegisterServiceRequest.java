package com.stl.telco_services.dto;

import com.stl.telco_services.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterServiceRequest {
    private String name;
    private Float price;
    private Status status;
}
