package com.mall.entry;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "sale_order")
@Component
public class SaleOrder {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id;
    @Column(name = "order_num")
    private String orderNum;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_num")
    private Integer productNum;
    @Column(name = "order_status")
    private Integer orderStatus;
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "create_time")
    private Date createTime;
}
