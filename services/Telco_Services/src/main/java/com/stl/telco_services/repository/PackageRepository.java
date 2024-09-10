package com.stl.telco_services.repository;

import com.stl.telco_services.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package,Long> {
}
