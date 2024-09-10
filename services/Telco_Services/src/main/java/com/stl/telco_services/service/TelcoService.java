package com.stl.telco_services.service;

import com.stl.telco_services.entity.Package;
import com.stl.telco_services.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelcoService {
    private final PackageRepository repository;


}
