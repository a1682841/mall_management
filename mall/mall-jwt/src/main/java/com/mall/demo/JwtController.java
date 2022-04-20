package com.mall.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/jwt")
public class JwtController {
    @PostMapping("/getAll")
    public ResponseEntity getAll(){

        return ResponseEntity.ok("success");
    }

    @PostMapping("/getToekn")
    public String getToekn(@RequestParam  String username,@RequestParam String password){
        HashMap<String, String> map = new HashMap<>();
        map.put("id",username);
        map.put("username", password);
        String token = JWTUtil.getToken(map);
        return token;
    }
}
