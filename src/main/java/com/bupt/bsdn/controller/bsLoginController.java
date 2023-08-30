package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.config.Result;
import com.bupt.bsdn.config.Utils;
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

    private bsUserService bsUserService;
    private bsRedisCacheService bsRedisCacheService;
    @Autowired

    public bsLoginController(bsUserService bsUserService,bsRedisCacheService bsRedisCacheService){
        this.bsUserService=bsUserService;
        this.bsRedisCacheService=bsRedisCacheService;
    }

    @PostMapping
    public JSONObject Login(@RequestBody JSONObject data){
        System.out.println(data);
        return Result.ok("true");
    }

}
