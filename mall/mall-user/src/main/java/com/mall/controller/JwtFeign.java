package com.mall.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "jwt-server",name = "jwt-server")
public interface JwtFeign {
    @RequestMapping(value = "jwt/getToekn", method = RequestMethod.POST)
    String getToekn(@RequestParam("username") String username, @RequestParam("password") String password);
}
