package com.stl.telco_services.controller;

public record DataRates(
        Integer dataValue,
        String validityPeriod,
        Double chargingRates
) {
}
