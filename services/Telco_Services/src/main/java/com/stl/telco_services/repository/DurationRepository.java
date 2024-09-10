package com.stl.telco_services.repository;

import com.stl.telco_services.entity.Duration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DurationRepository extends JpaRepository<Duration, Long> {
}
