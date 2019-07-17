package com.springboot.example.springbootdemo.dao;

import com.springboot.example.springbootdemo.model.City;

public interface CityMapper {
    City findCityById(int id);

    int insertCity(City record);

    int updateCity(City record);

    int deleteCity(int id);
}