package com.example.foodSer.services;

import com.example.foodSer.entity.Item;
import com.example.foodSer.entity.Menu;
import com.example.foodSer.model.ItemRequest;
import com.example.foodSer.model.MenuRequest;
import com.example.foodSer.repository.ItemRepository;
import com.example.foodSer.repository.MenuReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuServices {

    @Autowired
    private MenuReposiory menuReposiory;
    @Autowired
    private ItemRepository itemRepository;

    public Menu addMenu(MenuRequest menuRequest) {
        Menu menu = new Menu();
       // Menu saveMenu = menuReposiory.save(menu);
        List<Item> items = new ArrayList<>();

        for (ItemRequest itemRequest : menuRequest.getItemList()) {
            Item item = new Item();
            item.setName(itemRequest.getName());
            item.setPrice(itemRequest.getPrice());
            item.setDescription(itemRequest.getDescription());
            item.setMenu(menu);
            items.add(item);
        }
        menu.setItemList(items);
        return menuReposiory.save(menu);
    }

    public Menu getMenuByid(Long id) {
        return menuReposiory.findById(id).orElse(null);
    }

    public List<ItemRequest> getItemByMenuId(Long menuId) {
//        Menu menu = menuReposiory.findById(menuId)
//                .orElseThrow(() -> new RuntimeException("menu Not found"));
//        return menu.getItemList().stream().map(ItemMapper::toDTO).collect(Collectors.toList());

        return menuReposiory.findById(menuId)
                .orElseThrow(() -> new RuntimeException("menu Not found"))
                .getItemList().stream().map(item -> new ItemRequest(item.getId(),item.getName()
                        ,item.getPrice(),item.getDescription(),item.getMenu()))
                .collect(Collectors.toList());


//            return menu.getItemList().stream().map(item -> {
//                ItemRequest dto = new ItemRequest();
//                dto.setName(item.getName());
//                dto.setPrice(item.getPrice());
//                dto.setDescription(item.getDescription());
//                return dto;
//            }).collect(Collectors.toList());
        }

    public List<Menu> getListOfMenuIds() {
        return menuReposiory.findAll();
    }

//    public class ItemMapper {
//        public static ItemRequest toDTO(Item item) {
//            return new ItemRequest(item.getName(), item.getPrice(), item.getDescription());
//        }
//    }



//
//    public Item getByItemName(String name){
//        return menuReposiory.findByItemName(name);
//    }
//
//    public Item getByItemPrice(BigDecimal price){
//        return menuReposiory.findByItemPrice(price);
//    }



}
