package com.mall.controller;

import com.alibaba.fastjson.JSON;
import com.mall.entry.Product;
import com.mall.entry.ResponseDTO;
import com.mall.entry.SaleOrder;
import com.mall.mapper.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private InventoryFeign  inventoryFeign;

    @PostMapping("/getAll")
    public ResponseEntity queryStudent(){
        List<Product> list ;
        list = productRepository.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("getOne/{id}")
    public ResponseEntity queryStudent(@PathVariable(value = "id")  Integer id){
        Optional<Product> product = productRepository.findById(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping(value="/add")
    public ResponseEntity addStudent(@RequestBody Product product){
        product= productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity delete(@RequestParam Integer id){
        productRepository.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }


    @RequestMapping(value="/getProductByName")
    public List<Product> getByUserId(@RequestParam String productName){
        Product product = new Product();
        product.setName(productName);
        Example<Product> example = Example.of(product);
        List<Product> list = productRepository.findAll(example);
        return list;
    }


    @PostMapping(value="/update")
    public ResponseEntity update(@RequestBody Product product){
        product = productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping(value="/insertOrder")
    public ResponseEntity insertOrder(@RequestBody SaleOrder saleOrder){
        Integer productId = saleOrder.getProductId();
        Optional<Product> product = productRepository.findById(productId);
        BigDecimal orderPrice = product.get().getPrice().multiply(new BigDecimal(saleOrder.getProductNum()));
        saleOrder.setOrderAmount(orderPrice);
        saleOrder.setOrderNum(getOrderNo());
        saleOrder.setCreateTime(new Date());
        // send to orderService
        orderFeign.insertOrder(saleOrder);
        ResponseEntity responseEntity = inventoryFeign.updateInventory(saleOrder.getProductId(), saleOrder.getProductNum());
        return ResponseEntity.ok(responseEntity);
    }


    private static long orderNum = 0l;
    private static String date ;
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum  = 0l;
        }
        orderNum ++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;;
        return orderNo+"";
    }

    public static void main(String[] args) {
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setCardNumber("ss");
        saleOrder.setOrderNum("666");
        saleOrder.setOrderStatus(0);
        saleOrder.setProductId(1);
        saleOrder.setProductNum(66);
        saleOrder.setUserId(1);
        String json = JSON.toJSONString(saleOrder);
        System.out.println(json);
    }
}
