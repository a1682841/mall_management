package com.mall.inventory.controller;

import com.mall.entry.Product;
import com.mall.inventory.entry.ProductInventory;
import com.mall.inventory.mapper.ProductInventoryRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private ProductInventoryRepository productInventoryRepository;


    @PutMapping("/updateInventory")
    public ResponseEntity updateInventory(@RequestParam Integer productId,@RequestParam Integer productNum){
        ProductInventory productInventory =productInventoryRepository.findByProductId(productId);
        productInventory.setInventory(productInventory.getInventory()-productNum);
        productInventoryRepository.save(productInventory);
        return ResponseEntity.ok(null);
    }



}
