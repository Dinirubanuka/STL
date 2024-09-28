package com.stl.telco_services.repository;

import com.stl.telco_services.entity.DataUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUsageRepo extends JpaRepository<DataUsage, Long> {
}
