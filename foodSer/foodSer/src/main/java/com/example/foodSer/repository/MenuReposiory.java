package com.example.foodSer.repository;

import com.example.foodSer.entity.Item;
import com.example.foodSer.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MenuReposiory extends JpaRepository<Menu,Long> {
//
//    Item findByItemName(String name);
//
//    Item findByItemPrice(BigDecimal price);
}
