package com.springboot.example.springbootdemo.dao;

import com.springboot.example.springbootdemo.model.User;

public interface UserMapper {

    User findUserById(int id);
}