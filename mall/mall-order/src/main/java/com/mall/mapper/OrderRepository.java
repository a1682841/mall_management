package com.mall.mapper;

import com.mall.entry.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<SaleOrder,Integer> {

}

