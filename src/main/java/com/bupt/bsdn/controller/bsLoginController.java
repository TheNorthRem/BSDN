package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.util.Utils;
import com.bupt.bsdn.entity.bsUser;
import io.swagger.v3.oas.annotations.Operation;
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

    private final bsUserService bsuserService;
    private final bsRedisCacheService bsredisCacheService;
    @Autowired

    public bsLoginController(bsUserService bsuserService,bsRedisCacheService bsredisCacheService){
        this.bsuserService=bsuserService;
        this.bsredisCacheService=bsredisCacheService;
    }

    @PostMapping
    @Operation(summary = "登陆, 需要传递 username,password")
    public JSONObject Login(@RequestBody JSONObject data){
//        System.out.println(data);
        //从传入的JSON对象中读取参数
        String username = data.getString("username");
        String password = data.getString("password");

        bsUser user = bsuserService.getUserByUsername(username);

        if(user==null){ //判断用户名是否存在于数据库中
            return Result.error("用户名不存在");
        }

        if(password.equals(user.getPassword())){ //判断密码是否正确
            JSONObject res=new JSONObject();

            //返回userId 和 token
            Integer userId = user.getUserId();
            res.put("userId",userId);

            String token=bsredisCacheService.makeToken();
            bsredisCacheService.setToken(userId.toString(),token);
            res.put("token",token);

            return Result.ok(res);
        }
        return Result.error("用户名或者密码错误");
    }

    @PostMapping("/register")
    @Operation(summary = "注册, 需要传递 username,password")
    public JSONObject rigister(@RequestBody JSONObject data){
        //从前台数据中获取参数
        String username = data.getString("username");
        String password = data.getString("password");

        //检查密码是否合规

        if(!Utils.check(username,password)){
            return Result.error("用户名或密码不合要求！");
        }

        //用户名注册判重
        if(bsuserService.getUserByUsername(username)!=null){
            return Result.error("用户名已被注册！");
        }

        bsUser user =new bsUser();

        user.setUserName(username);
        user.setPassword(password);
        user.setPrivilege(0);

        //将用户存入后端数据库中
        boolean save = bsuserService.save(user);

        return Result.ok(save);
    }
}
