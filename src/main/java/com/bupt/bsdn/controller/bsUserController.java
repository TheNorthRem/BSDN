package com.bupt.bsdn.controller;

import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.service.bsUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bsUser")
@Slf4j
@Tag(name = "用户相关操作")
public class bsUserController {
    private final bsUserService bsUserService;

    @Autowired
    public bsUserController(bsUserService bsUserService) {
        this.bsUserService = bsUserService;
    }

    @GetMapping("/list")
    @Operation(summary = "查询全部用户")
    public List<bsUser> list() {
        return bsUserService.list();
    }

    @GetMapping("/searchID")
    @Operation(summary = "根据ID查询")
    public bsUser searchID(@RequestParam(name = "id") Integer id) {
        return bsUserService.getById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "增加用户")
    public Boolean add(@RequestBody bsUser bsUser) {
        bsUser.setUserId(null);
        return bsUserService.save(bsUser);
    }

    @PostMapping("/edit")
    @Operation(summary = "修改用户信息")
    public Boolean edit(@RequestBody bsUser bsUser) {
        return bsUserService.updateById(bsUser);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户信息")
    public Boolean delete(@RequestParam(name = "id") Integer id) {
        return bsUserService.removeById(id);
    }

    @GetMapping("/selectFive")
    @Operation(summary = "选前5本书")
    public List<bsUser> selectFive() {
        return bsUserService.selectFive();
    }
}
