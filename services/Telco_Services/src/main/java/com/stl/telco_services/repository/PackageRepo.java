package com.stl.telco_services.repository;

import com.stl.telco_services.entity.TelcoPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepo extends JpaRepository<TelcoPackage, Long> {
}
