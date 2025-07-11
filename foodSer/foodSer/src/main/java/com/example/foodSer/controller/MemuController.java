package com.example.foodSer.controller;

import com.example.foodSer.entity.Menu;
import com.example.foodSer.model.MenuRequest;
import com.example.foodSer.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MemuController {

    @Autowired
    private MenuServices menuServices;

    @PostMapping("/add")
    public ResponseEntity<Menu> addMenu(@RequestBody MenuRequest menuRequest){
        return new ResponseEntity<>(menuServices.addMenu(menuRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuByid(@PathVariable Long id){
        Menu menuByid = menuServices.getMenuByid(id);
        if(menuByid !=null){
            return ResponseEntity.ok(menuByid);
        }
        else {
           return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/menuIds")
    public ResponseEntity<List<Menu>> getListOfMenuIds(){
        return  ResponseEntity.ok(menuServices.getListOfMenuIds());
    }
//    @GetMapping("/name{name}")
//    public ResponseEntity<Item>getByItemName(@PathVariable String name){
//        return  ResponseEntity.ok(menuServices.getByItemName(name));
//    }
//    //can you implement this  item findByitemName (String name) controller and service , repository
//    @GetMapping("/price{price}")
//    public ResponseEntity<Item>getByItemPrice(@PathVariable BigDecimal price){
//        return  ResponseEntity.ok(menuServices.getByItemPrice(price));
//    }



}
