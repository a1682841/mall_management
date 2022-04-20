package com.mall.inventory.mapper;

import com.mall.inventory.entry.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory,Integer> {

    @Query("select c from product_inventory c where c.productId=?1")
    ProductInventory findByProductId(Integer productId);
}

