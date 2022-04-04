package com.example.util;

import com.example.domain.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;



    //判断是否存在key
    public  boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    //从redis中获取值
    public  Object get(String key){
        return  redisTemplate.opsForValue().get(key);
    }

    //向redis插入值
    public  boolean set(final String key,Object value){
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    public void remove(final String key){
        redisTemplate.delete(key);
    }

    public String getKey(int id){
        return "book:"+id;
    }

}
