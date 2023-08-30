package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.config.Result;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.service.bsUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bsUser")
@Slf4j
@Tag(name = "用户")
public class bsUserController {
    private final bsUserService bsUserService;

    @Autowired
    public bsUserController(bsUserService bsUserService) {
        this.bsUserService = bsUserService;
    }

    @GetMapping("/list")
    @Operation(summary = "查询全部用户")
    public JSONObject list() {
        return Result.ok(bsUserService.list());
    }

    @PostMapping("/add")
    @Operation(summary = "增加用户")
    public JSONObject add(@RequestBody bsUser bsUser) {
        bsUser.setUserId(null);
        return Result.ok(bsUserService.save(bsUser));
    }

    @PostMapping("/edit")
    @Operation(summary = "修改用户信息")
    public JSONObject edit(@RequestBody bsUser bsUser) {
        return Result.ok(bsUserService.updateById(bsUser));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户信息")
    public JSONObject delete(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsUserService.removeById(id));
    }

    @GetMapping("/getById")
    @Operation(summary = "根据ID查询")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsUserService.getById(id));
    }

    @GetMapping("/selectFive")
    @Operation(summary = "选前5个用户(目前仅用于测试mybatis-plus)")
    public JSONObject selectFive() {
        return Result.ok(bsUserService.selectFive());
    }

}
