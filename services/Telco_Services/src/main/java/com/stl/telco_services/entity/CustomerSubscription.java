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
@Table(name = "customer_subscription")
public class CustomerSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private String phone;

    @Column(name = "pay_type", nullable = false)
    private PayType payType;

    @Column(name = "base_package", nullable = false)
    private String basePackage;

    @Column(name = "credit_balance", nullable = false)
    private Integer creditBalance;

    @Column(name = "voice_balance", nullable = false)
    private Integer voiceBalance;

    @Column(name = "data_balance", nullable = false)
    private Integer dataBalance;

    @Column(name = "outstanding_amount", nullable = false)
    private Integer outstandingAmount;

    @Column(name = "subscribed_time", nullable = false)
    private Timestamp subscriptionDateTime;

}