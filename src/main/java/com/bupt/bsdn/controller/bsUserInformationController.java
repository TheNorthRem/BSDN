package com.bupt.bsdn.controller;

import com.bupt.bsdn.entity.bsUserInformation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.bsdn.service.bsUserInformationService;

import java.util.List;

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
    public List<bsUserInformation> list() {
        return bsUserInformationService.list();
    }

    @PostMapping("/add")
    @Operation(summary = "增加用户信息")
    public Boolean add(@RequestBody bsUserInformation bsUserInformation) {
        bsUserInformation.setUserId(null);
        return bsUserInformationService.save(bsUserInformation);
    }

    @PostMapping("/edit")
    @Operation(summary = "修改用户信息")
    public Boolean edit(@RequestBody bsUserInformation bsUserInformation) {
        return bsUserInformationService.updateById(bsUserInformation);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户信息")
    public Boolean delete(@RequestParam(name = "id") Integer id) {
        return bsUserInformationService.removeById(id);
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id获取用户信息")
    public bsUserInformation getById(@RequestParam(name = "id") Integer id) {
        return bsUserInformationService.getById(id);
    }
}
