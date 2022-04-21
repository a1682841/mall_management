package com.mall.controller;


import com.mall.entry.User;
import com.mall.mapper.MallUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * <p>
 *
 * </p>
 *
 * @author weijie liu
 * @since 2022-02-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    MallUserRepository mallUserRepository;

    @Autowired
    private JwtFeign jwtFeign;

    @PostMapping("/getAll")
    public ResponseEntity queryStudent(){
        List<User> list ;
        list = mallUserRepository.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("getOne/{id}")
    public ResponseEntity queryStudent(@PathVariable(value = "id")  Integer id){
        Optional<User> user = mallUserRepository.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping(value="/add")
    public ResponseEntity addStudent(@RequestBody User user){
        user= mallUserRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity delete(@RequestParam Integer id){
        mallUserRepository.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }

    @PostMapping(value="/update")
    public ResponseEntity update(@RequestBody User newUser){
        User user = mallUserRepository.save(newUser);
        return ResponseEntity.ok(user);
    }


    @PostMapping(value="/check")
    public ResponseEntity check(@RequestParam String username ,@RequestParam String password)throws Exception{
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        Example<User> example = Example.of(user);
        List<User> list = mallUserRepository.findAll(example);
        if(list.isEmpty()){
            return ResponseEntity.ok("Incorrect account or password");
        }
        String token = jwtFeign.getToekn(username, password);
        return ResponseEntity.ok(token);
    }

}
