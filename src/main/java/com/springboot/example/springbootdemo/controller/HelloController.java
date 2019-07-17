package com.springboot.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "index")
    public String sayHello(){
        return "Hello, world!";
    }
}
