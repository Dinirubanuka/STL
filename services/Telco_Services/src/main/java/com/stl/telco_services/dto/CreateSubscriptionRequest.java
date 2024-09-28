package com.stl.telco_services.dto;

import com.stl.telco_services.entity.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateSubscriptionRequest {

    private long customerId;
    private PayType payType;
    private String phone;
    private String basePackage;

}
