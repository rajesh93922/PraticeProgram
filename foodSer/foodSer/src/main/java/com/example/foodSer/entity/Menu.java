package com.example.foodSer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "menu")
@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Item> itemList;


}
