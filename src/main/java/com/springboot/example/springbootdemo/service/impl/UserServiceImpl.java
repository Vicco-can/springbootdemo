package com.springboot.example.springbootdemo.service.impl;

import com.springboot.example.springbootdemo.model.User;
import com.springboot.example.springbootdemo.service.UserService;
import com.springboot.example.springbootdemo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id){
        return userMapper.findUserById(id);
    }
}
