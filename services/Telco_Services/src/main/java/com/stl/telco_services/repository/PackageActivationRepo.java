package com.stl.telco_services.repository;

import com.stl.telco_services.entity.PackageActivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PackageActivationRepo extends JpaRepository<PackageActivation, Long> {
    Optional<List<PackageActivation>> findAllByCustomerId(Long customerId);
}
