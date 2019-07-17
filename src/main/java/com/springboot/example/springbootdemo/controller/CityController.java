package com.springboot.example.springbootdemo.controller;

import com.springboot.example.springbootdemo.model.City;
import com.springboot.example.springbootdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/findcity", method = RequestMethod.GET)
    public City findCity(@RequestParam(value = "id", required = true)int id){

        City city =  cityService.findCityById(id);
        return city;
    }

    @RequestMapping(value = "/insertcity", method = RequestMethod.POST)
    public void insertCity(@RequestParam(value = "city", required = true)City city){
        cityService.insertCity(city);
    }

    @RequestMapping(value = "/updatecity", method = RequestMethod.PUT)
    public  void updateCity(@RequestParam(value = "city", required = true)City city){
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/deletecity", method = RequestMethod.DELETE)
    public void deleteCity(@RequestParam(value = "id", required = true)int id){
        cityService.deleteCity(id);
    }

}
