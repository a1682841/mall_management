package com.mall.inventory.entry;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "product_inventory")
@Component
public class ProductInventory {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "inventory")
    private Integer inventory;
}
