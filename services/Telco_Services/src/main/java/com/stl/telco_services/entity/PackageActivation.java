package com.stl.telco_services.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer_package_activation")
public class PackageActivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TelcoPackage telcoPackage;

    @Column(name = "activated_time", nullable = false)
    private Timestamp activationDateTime;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "remaining", nullable = false)
    private float remaining;

}
