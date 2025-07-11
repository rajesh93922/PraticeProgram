package com.example.foodSer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Table(name = "customer")
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigInteger phoneNumber;
    private String email;
    private String password;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Menu menu;


}
