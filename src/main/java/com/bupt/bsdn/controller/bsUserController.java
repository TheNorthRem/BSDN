package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.entity.bsUserInformation;
import com.bupt.bsdn.service.bsUserInformationService;
import com.bupt.bsdn.service.bsUserService;
import com.bupt.bsdn.service.bsUserRecommendResultsService;
import com.bupt.bsdn.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    private final bsUserInformationService bsUserInformationService;

    private final bsUserRecommendResultsService bsUserRecommendResultsService;

    @Autowired
    public bsUserController(bsUserService bsUserService, bsUserInformationService bsUserInformationService, bsUserRecommendResultsService bsUserRecommendResultsService) {
        this.bsUserService = bsUserService;
        this.bsUserInformationService = bsUserInformationService;
        this.bsUserRecommendResultsService = bsUserRecommendResultsService;
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
        bsUser detailById = bsUserService.getDetailById(id);
        if (detailById != null)
            return Result.ok(detailById);
        return Result.error("用户不存在");
    }

    @GetMapping("/search")
    @Operation(summary = "根据用户名查找用户信息")
    @Parameter(name = "userName", description = "用户名")
    public JSONObject search(@RequestParam(name = "userName", defaultValue = "") String userName) {
        return Result.ok(bsUserService.search(userName));
    }

    @GetMapping("/recommend")
    @Operation(summary = "获取用户的推荐结果")
    @Parameter(name = "userId", description = "用户id")
    public JSONObject recommend(@RequestParam(name = "userId") Integer userId) {
        return Result.ok(bsUserRecommendResultsService.recommendList(userId));
    }

    @GetMapping("/recommendVisualization")
    @Operation(summary = "用户推荐结果可视化")
    @Parameter(name = "userId", description = "用户id")
    public JSONObject recommendVisualization(@RequestParam(name = "userId") Integer userId) {
        return Result.ok(bsUserRecommendResultsService.recommendVisualization(userId));
    }
}
