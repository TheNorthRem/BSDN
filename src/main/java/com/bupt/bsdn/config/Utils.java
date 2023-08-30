package com.bupt.bsdn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    private static Environment environment;

    @Autowired
    public void setEnvironment(Environment environment){
        Utils.environment=environment;
    }

    /**
     * 传入key 从配置文件中获取Value
     * 例：
     * Utils.getParamSettings("spring.data.redis.expirationTime")
     *返回值为String 自行对结果的类型进行更改
     *  */
    public static String getParamSettings(String key){
        return environment.getProperty(key);
    }
}
