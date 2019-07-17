package com.springboot.example.springbootdemo.service.impl;

import com.springboot.example.springbootdemo.dao.CityMapper;
import com.springboot.example.springbootdemo.model.City;
import com.springboot.example.springbootdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    /**

     * 获取城市逻辑：

     * 如果缓存存在，从缓存中获取城市信息

     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存

     */

    @Override
    public City findCityById(int id){
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(key);
        if(haskey){
            System.out.println("============从缓存获取数据==============");
            City cityResult = operations.get(key);
            System.out.println("=======================================");
            return cityResult;
        }

            System.out.println("============从数据表获取数据============");
            City cityResult = cityMapper.findCityById(id);
            System.out.println("=======================================");
            System.out.println("key   "+key);
            //写入缓存
            operations.set(key, cityResult); //, TimeUnit.SECONDS
            System.out.println("已写入缓存");
            return cityResult;
    }

        /**
        * 插入数据则直接插入
        */
    @Override
    public int insertCity(City city){

        return cityMapper.insertCity(city);
    }

    /**

     * 更新城市逻辑：

     * 如果缓存存在，删除

     * 如果缓存不存在，不操作

     */

    @Override
    public int updateCity(City city){
        String key = "city_" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String,City> operations = redisTemplate.opsForValue();

        if (hasKey){
            System.out.println("=======缓存中存在需更新记录，删除=======");
            redisTemplate.delete(key);
            System.out.println("=====================================");
        }
        return cityMapper.updateCity(city);
    }

    /**
     *删除逻辑：
     * 删除数据库记录，若缓存中存在，则一起删除
     *
     */

    @Override
    public int deleteCity(int id){
        int del = cityMapper.deleteCity(id);
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            System.out.println("=======缓存中存在需删除记录，删除=======");
            redisTemplate.delete(key);
            System.out.println("=====================================");
        }
        return del;
    }

}
