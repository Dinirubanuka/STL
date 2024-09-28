package com.stl.telco_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubscribeServiceRequest {
    private long customerId;
    private long serviceId;
}
