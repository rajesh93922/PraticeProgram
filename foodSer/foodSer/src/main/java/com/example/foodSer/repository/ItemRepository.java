package com.example.foodSer.repository;

import com.example.foodSer.entity.Item;
import com.example.foodSer.model.ItemRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
  //  @Query("Select i from item  i where i.name= :name")
    List<ItemRequest> findByNameIgnoreCase(String name);

   // List<ItemRequest> findByPrice(BigDecimal price);

  @Query("SELECT new com.example.foodSer.model.ItemRequest(i.id, i.name, i.price, i.description ,i.menu) " +
          "FROM Item i WHERE i.price BETWEEN :price - 0.01 AND :price + 0.01")
  List<ItemRequest> findByPrice(@Param("price") BigDecimal price);

}
