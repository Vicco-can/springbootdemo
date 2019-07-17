package com.springboot.example.springbootdemo.controller;

import com.springboot.example.springbootdemo.model.User;
import com.springboot.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/finduser")
    public User findUserById(@RequestParam(value = "id", required = true) int id){
        User user = userService.findUserById(id);
        return user;
    }
}
