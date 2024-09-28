package com.stl.telco_services.service;

import com.stl.telco_services.dto.AnyResponse;
import com.stl.telco_services.dto.RegisterServiceRequest;
import com.stl.telco_services.repository.ServiceRepo;
import com.stl.telco_services.entity.TelcoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private AnyResponse anyResponse;

    @Autowired
    private ModelMapper modelMapper;

    public AnyResponse addService(RegisterServiceRequest tel_service) {
        try {
            TelcoService newService = serviceRepo.save(modelMapper.map(tel_service, TelcoService.class));
            anyResponse.setMessage("Service saved successfully");
            anyResponse.setData(newService);
            return anyResponse;
        } catch (Exception e) {
            anyResponse.setMessage("Error in saving data " + e.getMessage());
            anyResponse.setData(null);
            return anyResponse;
        }
    }

    public List<TelcoService> getAllServices() {
        return serviceRepo.findAll();
    }

}
