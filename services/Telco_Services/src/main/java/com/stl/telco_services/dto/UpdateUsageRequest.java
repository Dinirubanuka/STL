package com.stl.telco_services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateUsageRequest {
    private long packageActivationId;
    private int usage;
}
