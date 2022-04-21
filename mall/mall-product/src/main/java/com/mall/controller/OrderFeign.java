package com.mall.controller;

import com.mall.entry.SaleOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "order-server",name = "order-server")
public interface OrderFeign {
    @RequestMapping(value = "order/insert", method = RequestMethod.POST)
    public ResponseEntity insertOrder(@RequestBody SaleOrder saleOrder);
}
