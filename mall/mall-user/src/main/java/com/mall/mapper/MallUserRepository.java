package com.mall.mapper;

import com.mall.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallUserRepository extends JpaRepository<User,Integer> {
}

