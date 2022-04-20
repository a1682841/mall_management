package com.mall.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "inventory-server",name = "inventory-server")
public interface InventoryFeign {

    @PutMapping("inventory/updateInventory")
    public ResponseEntity updateInventory(@RequestParam("productId") Integer productId, @RequestParam("productNum") Integer productNum);
}
