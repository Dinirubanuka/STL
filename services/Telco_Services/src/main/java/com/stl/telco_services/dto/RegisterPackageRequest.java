package com.stl.telco_services.dto;

import com.stl.telco_services.entity.PayType;
import com.stl.telco_services.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterPackageRequest {
    private String name;
    private Float price;
    private Integer size;
    private PayType payType;
    private ServiceType serviceType;
}
