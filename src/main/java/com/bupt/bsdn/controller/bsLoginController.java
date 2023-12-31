package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.entity.bsUserInformation;
import com.bupt.bsdn.service.bsRedisCacheService;
import com.bupt.bsdn.service.bsUserService;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.bsdn.service.bsUserInformationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/login")
@Slf4j
@Tag(name = "登录界面")
public class bsLoginController {

    private final bsUserService bsuserService;
    private final bsRedisCacheService bsredisCacheService;

    private final bsUserInformationService bsUserInformationService;

    @Autowired
    public bsLoginController(bsUserService bsuserService, bsRedisCacheService bsredisCacheService, bsUserInformationService bsUserInformationService) {
        this.bsuserService = bsuserService;
        this.bsredisCacheService = bsredisCacheService;
        this.bsUserInformationService = bsUserInformationService;
    }

    @PostMapping
    @Operation(summary = "登陆, 需要传递 username,password")
    public JSONObject Login(@RequestBody JSONObject data) {
//        System.out.println(data);
        //从传入的JSON对象中读取参数
        String username = data.getString("username");
        String password = data.getString("password");


        //登录校验
        QueryWrapper<bsUser> bsUserQueryWrapper = new QueryWrapper<>();
        bsUserQueryWrapper.eq("userName", username);
        long count = bsuserService.count(bsUserQueryWrapper);

        if (count == 0) { //判断用户名是否存在于数据库中
            return Result.error("用户名不存在");
        }

        if (count > 1) { //判断用户名是否出现重复
            log.error("发现数据库出现重复数据！" + "userName:" + username);
            return Result.error("用户名重复，请联系客服!");
        }

        //获取用户名
        bsUser user = bsuserService.getUserByUsername(username);
        if (password.equals(user.getPassword())) { //判断密码是否正确
            JSONObject res = new JSONObject();

            //返回userId 和 token
            Integer userId = user.getUserId();
            res.put("userId", userId);

            String token = bsredisCacheService.makeToken();
            bsredisCacheService.setToken(userId.toString(), token);
            res.put("token", token);

            return Result.ok(res);
        }
        return Result.error("用户名或者密码错误");
    }

    @PostMapping("/register")
    @Operation(summary = "注册, 需要传递 username,password, QQ, birthday(Date), intro")
    public JSONObject register(@RequestBody JSONObject data) {
        //从前台数据中获取参数
        String username = data.getString("username");
        String password = data.getString("password");
        String QQ = data.getString("QQ");
        Date birthday;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(data.getString("birthday"));
        } catch (ParseException parseException) {
            log.warn("日期规范不符:" + data.getString("birthday"));
            return Result.error("日期规范不符:" + data.getString("birthday"));
        }
        String intro = data.getString("intro");


        //检查密码是否合规
        if (!Utils.check(username, password)) {
            return Result.error("用户名或密码不合要求！");
        }

        //检测QQ号规范
        if (QQ.length() < 5 || QQ.length() > 13)
            return Result.error("QQ号长度不符合规范!");

        for (int i = 0; i < QQ.length(); i++) {
            if (QQ.charAt(i) < '0' || QQ.charAt(i) > '9')
                return Result.error("QQ号不符合规范!");
        }

        //用户名注册判重
        QueryWrapper<bsUser> bsUserQueryWrapper = new QueryWrapper<>();
        bsUserQueryWrapper.eq("userName", username);
        if (bsuserService.count(bsUserQueryWrapper) != 0) {
            return Result.error("用户名已被注册！");
        }

        bsUser user = new bsUser();

        user.setUserName(username);
        user.setPassword(password);
        //注册的时候默认nickname == username
        user.setNickName(username);
        user.setPrivilege(0);

        //将用户存入bs_user表中
        if (!bsuserService.save(user)) {
            log.error("bs_user表插入失败!");
            return Result.error("注册失败，请联系客服");
        }

        //获取id
        Integer userId;
        try {
            userId = bsuserService.list(bsUserQueryWrapper).get(0).getUserId();
        } catch (IndexOutOfBoundsException exception) {
            log.error("bs_user表出现错误!");
            return Result.error("后台出现错误，请联系客服!");
        }

        //同步bs_userInformation表
        bsUserInformation bsUserInformation = new bsUserInformation();
        bsUserInformation.setInformationId(null);
        bsUserInformation.setUserId(userId);
        bsUserInformation.setQQ(QQ);
        bsUserInformation.setBirthday(birthday);
        bsUserInformation.setIntro(intro);
        bsUserInformation.setArticleCount(0);
        bsUserInformation.setFavoriteCount(0);
        bsUserInformation.setClickCounts(0);
        bsUserInformationService.save(bsUserInformation);

        return Result.ok("注册成功!");
    }

    @DeleteMapping("/logOut")
    @Operation(summary = "登出")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "token", description = "token")})
    public JSONObject logOut(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "token") String token) {
        if (!bsredisCacheService.hasToken(String.valueOf(userId)) || !bsredisCacheService.getToken(String.valueOf(userId)).equals(token)) {
            return Result.error("无token或token核验错误");
        }
        bsredisCacheService.deleteToken(String.valueOf(userId));
        return Result.ok("登出成功!");
    }

    @GetMapping("/getToken")
    @Operation(summary = "获取token")
    @Parameter(name = "id", description = "用户id")
    public JSONObject getToken(@RequestParam(name = "id") Integer id) {
        if (bsredisCacheService.hasToken(String.valueOf(id)))
            return Result.ok(bsredisCacheService.getToken(String.valueOf(id)));
        return Result.error("无token或token过期");
    }
}
