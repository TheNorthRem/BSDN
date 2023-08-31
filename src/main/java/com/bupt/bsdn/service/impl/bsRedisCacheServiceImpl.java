package com.bupt.bsdn.service.impl;

import com.bupt.bsdn.util.Utils;
import com.bupt.bsdn.service.bsRedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Redis缓存层，用来存储token令牌
 * @author: syc
 * @date: 2023年08月29日 17:25
 */
@Service
public class bsRedisCacheServiceImpl implements bsRedisCacheService {
    private final RedisTemplate<String, String> redisTemplate;


    @Autowired
    public bsRedisCacheServiceImpl(RedisTemplate<String, String> redisTemplate, Environment environment) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Boolean hasToken(String userId) {
        return redisTemplate.hasKey(userId);
    }

    @Override
    public Boolean deleteToken(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public void setToken(String userId, String token) {
        redisTemplate.opsForValue().set(userId, token, Long.parseLong(Utils.getParamSettings("expirationTime")), TimeUnit.SECONDS);
    }

    @Override
    public String getToken(String userId) {
        return redisTemplate.opsForValue().get(userId);
    }

    @Override
    public String makeToken() {
        String string = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        int length = Integer.parseInt(Utils.getParamSettings("tokenLength"));
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(string.charAt(number));
        }
        return stringBuffer.toString();
    }
}
