package com.example.foodSer.services;

import com.example.foodSer.entity.Item;
import com.example.foodSer.entity.Menu;
import com.example.foodSer.model.ItemDto;
import com.example.foodSer.model.ItemRequest;
import com.example.foodSer.repository.ItemRepository;
import com.example.foodSer.repository.MenuReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {

    @Autowired
    private MenuReposiory menuReposiory;

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        if(item.getMenu() !=null && item.getMenu().getId() !=null){
            Menu menu = menuReposiory.findById(item.getMenu().getId())
                    .orElseThrow(() -> new RuntimeException("menu not found"));
            item.setMenu(menu);
        }
        return itemRepository.save(item);
    }

    public Item getIteamById(Long id) {
        return itemRepository.findById(id).orElse(null);

    }

    public List<ItemRequest> getByItemName(String name) {
        return itemRepository.findByNameIgnoreCase(name);
    }

    public List<ItemRequest> getItemByPrice(BigDecimal price) {
        return itemRepository.findByPrice(price);
    }

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    public Item addItemWithMenuId(Long id, ItemDto itemDto) {
        Item item = new Item();
        Optional<Menu> menu = menuReposiory.findById(id);
        if (menu.isPresent()) {

            item.setMenu(menu.get());
        } else {
            Menu menu1 = new Menu();
            menuReposiory.save(menu1);
            item.setMenu(menu1);
        }
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        return itemRepository.save(item);


    }
}
