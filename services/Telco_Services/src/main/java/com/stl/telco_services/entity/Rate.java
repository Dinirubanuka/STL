package com.stl.telco_services.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "data_id")
    private Package dataPackage;

    @ManyToOne
    @JoinColumn(name = "duration_id")
    private Duration duration;

    private double rate;
}
