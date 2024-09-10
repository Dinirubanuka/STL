package com.stl.telco_services.repository;

import com.stl.telco_services.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate,Long> {
}
