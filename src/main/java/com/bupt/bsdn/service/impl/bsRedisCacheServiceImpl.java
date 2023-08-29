package com.bupt.bsdn.service.impl;

import com.bupt.bsdn.service.bsRedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description: Redis缓存层，用来存储token令牌
 * @author: syc
 * @date: 2023年08月29日 17:25
 */
public class bsRedisCacheServiceImpl implements bsRedisCacheService {
    private final RedisTemplate<String, String> redisTemplate;
    private final int expirationTime; //过期时间(秒)

    @Autowired
    public bsRedisCacheServiceImpl(RedisTemplate<String, String> redisTemplate, @Value("${expirationTime}") int expirationTime) {
        this.redisTemplate = redisTemplate;
        this.expirationTime = expirationTime;
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
        redisTemplate.opsForValue().set(userId, token, expirationTime, TimeUnit.SECONDS);
    }

    @Override
    public String getToken(String userId) {
        return redisTemplate.opsForValue().get(userId);
    }
}
