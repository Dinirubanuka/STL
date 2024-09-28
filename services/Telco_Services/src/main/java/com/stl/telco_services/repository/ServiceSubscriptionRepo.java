package com.stl.telco_services.repository;

import com.stl.telco_services.entity.ServiceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceSubscriptionRepo extends JpaRepository<ServiceSubscription, Long> {
    Optional<List<ServiceSubscription>> findAllByCustomerId(Long customerId);
}
