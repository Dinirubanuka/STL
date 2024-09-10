package com.stl.telco_services.controller;

public record dataAddOnRequest(
        Long customerId,
        Integer dataValue,
        Integer validityPeriod,
        Integer charge
) {
}
