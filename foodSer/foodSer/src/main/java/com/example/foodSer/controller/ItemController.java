package com.example.foodSer.controller;

import com.example.foodSer.entity.Item;
import com.example.foodSer.entity.Menu;
import com.example.foodSer.model.ItemDto;
import com.example.foodSer.model.ItemRequest;
import com.example.foodSer.services.ItemServices;
import com.example.foodSer.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:4200")
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemServices itemServices;
    @Autowired
    private MenuServices menuServices;

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        return new ResponseEntity<>(itemServices.addItem(item), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
     public Item getIteamById(@PathVariable Long id){
       return  itemServices.getIteamById(id);

    }
    @GetMapping("/{menuId}/menues")
    public ResponseEntity<List<ItemRequest>> getItemByMenuId(@PathVariable Long menuId){
        return ResponseEntity.ok(menuServices.getItemByMenuId(menuId));
    }

    @GetMapping("/{name}/itemName")
    public ResponseEntity<List<ItemRequest>>getByItemName(@PathVariable String name){
        return ResponseEntity.ok(itemServices.getByItemName(name));
    }

    @GetMapping("/by-price")
    public ResponseEntity<List<ItemRequest>>getItemByPrice(@RequestParam("price") BigDecimal price){
        return ResponseEntity.ok(itemServices.getItemByPrice(price));
    }
    @GetMapping("/allItem")
    public ResponseEntity<List<Item>>getAllItem(){
        return ResponseEntity.ok(itemServices.getAllItem());
    }

    @PostMapping("/saveItemWithMenuId/{id}")
    public ResponseEntity<Item> addItemWithMenuId(@PathVariable Long id,@RequestBody ItemDto itemDto){
        return new ResponseEntity<>(itemServices.addItemWithMenuId(id,itemDto), HttpStatus.CREATED);
    }









}









