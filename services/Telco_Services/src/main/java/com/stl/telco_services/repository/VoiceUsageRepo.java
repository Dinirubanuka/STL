package com.stl.telco_services.repository;

import com.stl.telco_services.entity.VoiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoiceUsageRepo extends JpaRepository<VoiceUsage, Long> {
}
