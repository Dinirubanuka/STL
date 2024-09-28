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
@Table(name = "voice_usage")
public class VoiceUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "activation_id", nullable = true)
    private PackageActivation activation;

    @Column(name = "record_time", nullable = false)
    private Timestamp recordDateTime;

    @Column(nullable = false)
    private int usage;
}
