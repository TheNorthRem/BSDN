package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.entity.bsUserInformation;
import com.bupt.bsdn.service.bsUserInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bsUserInformation")
@Slf4j
@Tag(name = "用户信息")
public class bsUserInformationController {
    private final bsUserInformationService bsUserInformationService;

    @Autowired
    public bsUserInformationController(bsUserInformationService bsUserInformationService) {
        this.bsUserInformationService = bsUserInformationService;
    }

    @GetMapping("/list")
    @Operation(summary = "获取全部用户信息")
    public JSONObject list() {
        return Result.ok(bsUserInformationService.list());
    }

    @PostMapping("/add")
    @Operation(summary = "增加用户信息")
    public JSONObject add(@RequestBody bsUserInformation bsUserInformation) {
        bsUserInformation.setInformationId(null);
        return Result.ok(bsUserInformationService.save(bsUserInformation));
    }

    @PostMapping("/edit")
    @Operation(summary = "修改用户信息")
    public JSONObject edit(@RequestBody bsUserInformation bsUserInformation) {
        return Result.ok(bsUserInformationService.updateById(bsUserInformation));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户信息")
    public JSONObject delete(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsUserInformationService.removeById(id));
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id获取用户信息")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsUserInformationService.getById(id));
    }
}
