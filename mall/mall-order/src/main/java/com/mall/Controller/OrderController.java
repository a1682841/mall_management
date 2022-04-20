package com.mall.Controller;

import com.mall.entry.SaleOrder;
import com.mall.mapper.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping(value="/insert")
    public ResponseEntity insert(@RequestBody SaleOrder saleOrder){
        saleOrder= orderRepository.save(saleOrder);
        return ResponseEntity.ok(saleOrder);
    }

}
