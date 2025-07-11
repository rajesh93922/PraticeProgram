package com.example.foodSer.model;

import com.example.foodSer.entity.Menu;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemRequest {

    private Long id;

    private String name;
    private BigDecimal price;
    private String description;

    private Menu menu;

    public ItemRequest(Long id, String name, BigDecimal price, String description, Menu menu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.menu = menu;
    }


}
