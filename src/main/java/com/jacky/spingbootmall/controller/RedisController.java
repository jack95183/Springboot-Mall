package com.jacky.spingbootmall.controller;

import com.jacky.spingbootmall.service.RedisService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/save")
    public void save(@RequestParam String key, @RequestParam String value) {
        redisService.save(key, value);
    }

    @GetMapping("/get")
    public Object get(@RequestParam String key) {
        return redisService.get(key);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String key) {
        redisService.delete(key);
    }

    // 新增其他常用型態的操作
    @PostMapping("/saveInt")
    public void saveInt(@RequestParam String key, @RequestParam int value) {
        redisService.saveInt(key, value);
    }

    @GetMapping("/getInt")
    public int getInt(@RequestParam String key) {
        return redisService.getInt(key);
    }

    @PostMapping("/saveList")
    public void saveList(@RequestParam String key, @RequestBody List<String> list) {
        redisService.saveList(key, list);
    }

    @GetMapping("/getList")
    public List<String> getList(@RequestParam String key) {
        return redisService.getList(key);
    }
}