package com.bupt.bsdn.service;

/**
 * @Description: Redis缓存层，用来存储token令牌
 * @author: syc
 * @date: 2023年08月29日 17:25
 */
public interface bsRedisCacheService {

    /**
     * 判断是否存在key
     */
    Boolean hasToken(String userId);

    /**
     * 删除token(登出时使用)
     */
    Boolean deleteToken(String key);

    /**
     * 存储userID-token
     */
    void setToken(String userId, String token);

    /**
     * 根据userId获取token
     * 若没有或者已经失效则返回null
     */
    String getToken(String userId);

    /**
     * 产生token(通过随机数)
     */
    String makeToken();
}
