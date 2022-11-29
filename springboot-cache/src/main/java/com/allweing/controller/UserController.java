package com.allweing.controller;

import com.allweing.pojo.User;
import com.allweing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: zzzgyu
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id") Long id ) {
       User user = userService.queryUserById(id);
       return user;
    }

    @PutMapping("user/{id}")
    public String updataUserById( @PathVariable("id") Long id ) {
        userService.updataUserById(id);

        return "success";
    }
}
