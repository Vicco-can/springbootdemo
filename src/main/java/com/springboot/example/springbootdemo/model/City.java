package com.springboot.example.springbootdemo.model;

import java.io.Serializable;

public class City implements Serializable{
    private Integer id;

    private String cityName;

    private String provinceIn;

    private String description;

    public City(Integer id, String cityName, String provinceIn, String description) {
        this.id = id;
        this.cityName = cityName;
        this.provinceIn = provinceIn;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getProvinceIn() {
        return provinceIn;
    }

    public void setProvinceIn(String provinceIn) {
        this.provinceIn = provinceIn == null ? null : provinceIn.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}