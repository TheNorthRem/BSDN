package com.bupt.bsdn.config;

import com.bupt.bsdn.interceptor.bsLoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
<<<<<<< HEAD
        log.info("bsLoginInterceptor init");
        /*registry.addInterceptor(new bsLoginInterceptor()).
                addPathPatterns().excludePathPatterns("/", "/login", "/swagger-ui/**", "/v3/**", Utils.getParamSettings("logicIndexPath"));*/
        log.info("bsLoginInterceptor init success");
=======
//        log.info("bsLoginInterceptor init");
//        registry.addInterceptor(new bsLoginInterceptor()).
//                addPathPatterns().excludePathPatterns("/", "/login", "/swagger-ui/**", "/v3/**", Utils.getParamSettings("logicIndexPath"));
//        log.info("bsLoginInterceptor init success");
>>>>>>> b6294ba2bd416f181e62a3e591570318b100f069
    }
}
