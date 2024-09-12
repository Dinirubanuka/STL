package com.stl.telco_services.controller;

public record DataAddOnRequest(
        Long customerId,
        Integer dataValue,
        Integer validityPeriod,
        Integer charge
) {
}
