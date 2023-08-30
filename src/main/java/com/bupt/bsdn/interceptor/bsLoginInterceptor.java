package com.bupt.bsdn.interceptor;


import com.bupt.bsdn.config.Utils;
import com.bupt.bsdn.service.bsRedisCacheService;
import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 登录拦截器
 */
@Slf4j
@Component
public class bsLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private bsRedisCacheService bsRedisCacheService;

    public bsLoginInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler) throws IOException {
        String ip = request.getRemoteAddr(); //获取ip
        System.out.println("------------过滤器-------------------");
        if (handler instanceof ResourceHttpRequestHandler) { //静态资源请求
            log.info("A static resource request was made, ip:" + ip);
        } else if (handler instanceof HandlerMethod handlerMethod) { //业务逻辑请求
            Method method = handlerMethod.getMethod();
            log.info("A business logic request was made, ip:" + ip + ", target:" + method.getDeclaringClass().getName() + ", method:" + method.getName());
        }

        //token解析
        String userId = (String) request.getSession().getAttribute("userId");
        String token = (String) request.getSession().getAttribute("token");

        //token验证

        if (userId == null) { //用户id为空
            log.error("Interceptor request, but userId is null, ip:" + ip);
            response.sendRedirect(Utils.getParamSettings("logicIndexPath"));
            return false;
        }

        if (bsRedisCacheService.getToken(userId) == null) { //token过期
            log.error("Interceptor request, but token is expired, ip:" + ip);
            response.sendRedirect(Utils.getParamSettings("logicIndexPath"));
            return false;
        }
        if (!bsRedisCacheService.getToken(userId).equals(token)) { //token不等
            log.error("Interceptor request, but token is wrong, ip:" + ip + "send token is " + token + ", redis token is" + bsRedisCacheService.getToken(userId));
            response.sendRedirect(Utils.getParamSettings("logicIndexPath"));
            return false;
        }
        return true;
    }
}