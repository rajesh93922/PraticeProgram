package com.example.foodSer.model;

import com.example.foodSer.entity.Item;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class MenuRequest {


    private Long id;

    private List<ItemRequest> itemList;

}
