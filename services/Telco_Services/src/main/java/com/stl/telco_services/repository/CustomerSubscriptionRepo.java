package com.stl.telco_services.repository;

import com.stl.telco_services.entity.CustomerSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerSubscriptionRepo extends JpaRepository<CustomerSubscription, Long> {
    Optional<CustomerSubscription> findByCustomerId(long id);
    Optional<List<CustomerSubscription>> findAllByCustomerId(long id);
}
