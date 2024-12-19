package com.jacky.spingbootmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // 新增其他常用型態的操作
    public void saveInt(String key, int value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public int getInt(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value != null ? (int) value : 0;
    }

    public void saveList(String key, List<String> list) {
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    public List<String> getList(String key) {
        List<Object> objects = redisTemplate.opsForList().range(key, 0, -1);
        if (objects == null) {
            return null; // 或者根据你的需求返回一个空列表
        }
        return objects.stream()
                .filter(obj -> obj instanceof String)
                .map(obj -> (String) obj)
                .collect(Collectors.toList());
    }
}