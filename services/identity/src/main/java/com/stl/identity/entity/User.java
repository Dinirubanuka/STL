package com.stl.identity.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false ,unique = true)
    private String firstname;
    private String lastname;

    @Column(nullable = false ,unique = true)
    private String email;
    @Column(nullable = false ,unique = true)
    private String NIC;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String mobileNumber;
}
