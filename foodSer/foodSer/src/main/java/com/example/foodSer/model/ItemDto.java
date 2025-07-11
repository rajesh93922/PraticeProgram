package com.example.foodSer.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ItemDto {
    private String name;
    private BigDecimal price;
    private String description;
    private Long menuId;

}
