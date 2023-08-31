package com.bupt.bsdn.config;

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
//        log.info("bsLoginInterceptor init");
//        registry.addInterceptor(new bsLoginInterceptor()).
//                addPathPatterns().excludePathPatterns("/", "/login", "/swagger-ui/**", "/v3/**", Utils.getParamSettings("logicIndexPath"));
//        log.info("bsLoginInterceptor init success");
    }
}
