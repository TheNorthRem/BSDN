package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.bsdn.entity.bsUserInformation;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.service.bsUserService;
import com.bupt.bsdn.service.bsUserInformationService;
import com.bupt.bsdn.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/bsUser")
@Slf4j
@Tag(name = "用户")
public class bsUserController {
    private final bsUserService bsUserService;

    private final bsUserInformationService bsUserInformationService;

    @Autowired
    public bsUserController(bsUserService bsUserService, bsUserInformationService bsUserInformationService) {
        this.bsUserService = bsUserService;
        this.bsUserInformationService = bsUserInformationService;
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
        QueryWrapper<bsUser> bsUserQueryWrapper = new QueryWrapper<>();
        QueryWrapper<bsUserInformation> bsUserInformationQueryWrapper = new QueryWrapper<>();
        bsUserQueryWrapper.eq("user_id", id);
        bsUserInformationQueryWrapper.eq("userId", id);
        if (!bsUserService.list(bsUserQueryWrapper).isEmpty() && !bsUserInformationService.list(bsUserInformationQueryWrapper).isEmpty()) {
            bsUserService.remove(bsUserQueryWrapper);
            bsUserInformationService.remove(bsUserInformationQueryWrapper);
            return Result.ok("删除成功!");
        }
        return Result.error("删除失败!");
    }

    @GetMapping("/getById")
    @Operation(summary = "根据ID查询")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsUserService.getDetailById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "根据用户名查找用户信息")
    @Parameter(name = "userName", description = "用户名")
    public JSONObject search(@RequestParam(name = "userName", defaultValue = "") String userName) {
        return Result.ok(bsUserService.search(userName));
    }

    @PostMapping("/uploadAvatar")
    @Operation(summary = "上传头像")
    public JSONObject uploadAvatar(@RequestParam(value = "image") MultipartFile file, @RequestParam(value = "id") Integer id) {
        String name = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        bsUser user = bsUserService.getById(id);
        name = id + name;

        if (user == null) {
            return Result.error("user is null");
        }

        File image = new File(Utils.getParamSettings("avatarPath") + name);
        try {
            file.transferTo(image);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        user.setAvatar(name);

        bsUserService.save(user);

        return Result.ok("success");
    }
}
