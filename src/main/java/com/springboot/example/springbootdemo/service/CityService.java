package com.springboot.example.springbootdemo.service;

import com.springboot.example.springbootdemo.model.City;

public interface CityService {

    City findCityById (int id);

    int insertCity(City city);

    int updateCity(City city);

    int deleteCity(int id);

}
