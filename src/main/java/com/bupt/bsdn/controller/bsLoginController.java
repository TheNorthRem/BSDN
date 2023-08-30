package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.config.Result;
import com.bupt.bsdn.entity.bsUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bupt.bsdn.service.bsUserService;
import com.bupt.bsdn.service.bsRedisCacheService;

@RestController
@RequestMapping("/login")
@Slf4j
@Tag(name = "登录界面")
public class bsLoginController {

    private bsUserService bsuserService;
    private bsRedisCacheService bsredisCacheService;
    @Autowired

    public bsLoginController(bsUserService bsuserService,bsRedisCacheService bsredisCacheService){
        this.bsuserService=bsuserService;
        this.bsredisCacheService=bsredisCacheService;
    }

    @PostMapping
    public JSONObject Login(@RequestBody JSONObject data){
        System.out.println(data);

        String username = data.getString("username");
        String password = data.getString("password");

        bsUser user = bsuserService.getUserByUsername(username);

        if(user==null){
            return Result.error("用户名不存在");
        }

        if(password.equals(user.getPassword())){

            JSONObject res=new JSONObject();

            Integer userId = user.getUserId();
            res.put("userId",userId);

            return Result.ok(res);
        }
        return Result.error("用户名或者密码错误");
    }

}
