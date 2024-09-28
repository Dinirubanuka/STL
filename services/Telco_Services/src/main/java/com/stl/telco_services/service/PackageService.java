package com.stl.telco_services.service;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.RegisterPackageRequest;
import com.stl.telco_services.entity.TelcoPackage;
import com.stl.telco_services.repository.PackageRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PackageService {
    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private AnyResponse anyResponse;

    @Autowired
    private ModelMapper modelMapper;

    public AnyResponse addPackage(RegisterPackageRequest tel_package) {
        try {
            TelcoPackage newPackage = packageRepo.save(modelMapper.map(tel_package, TelcoPackage.class));
            anyResponse.setMessage("Package saved successfully");
            anyResponse.setData(newPackage);
            return anyResponse;
        } catch (Exception e) {
            anyResponse.setMessage("Error in saving data " + e.getMessage());
            anyResponse.setData(null);
            return anyResponse;
        }
    }

    public List<TelcoPackage> getAllPackages() {
        return packageRepo.findAll();
    }
}
