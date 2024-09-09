package com.stl.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Customer {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String NIC;
    private String password;

}
