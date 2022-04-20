package com.mall.entry;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "product")
@Component
public class Product {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "size")
    private String size;
    @Column(name = "color")
    private String color;
    @Column(name = "image")
    private String image;
}
