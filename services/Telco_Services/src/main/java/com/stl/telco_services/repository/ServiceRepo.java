package com.stl.telco_services.repository;

import com.stl.telco_services.entity.TelcoService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<TelcoService, Long> {
}
