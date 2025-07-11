package com.example.foodSer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Table(name = "item")
@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Item(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Item() {

    }
}
