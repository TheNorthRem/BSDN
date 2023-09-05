package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bupt.bsdn.entity.bsFavorites;
import com.bupt.bsdn.service.bsFavoritesService;
import com.bupt.bsdn.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bsFavorites")
@Slf4j
@Tag(name = "关注")
public class bsFavoritesController {
    private final bsFavoritesService bsFavoritesService;

    @Autowired
    public bsFavoritesController(bsFavoritesService bsFavoritesService) {
        this.bsFavoritesService = bsFavoritesService;
    }

    @GetMapping("/followers")
    @Operation(summary = "获取关注该用户的全部用户信息")
    @Parameter(name = "id", description = "用户id")
    public JSONObject followers(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsFavoritesService.followers(id));
    }

    @GetMapping("/following")
    @Operation(summary = "获取该用户关注的所有用户信息")
    @Parameter(name = "id", description = "用户id")
    public JSONObject following(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsFavoritesService.following(id));
    }

    @PostMapping("/addFollowing")
    @Operation(summary = "增加该用户的关注列表成员(用户--关注-->成员)")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "followingId", description = "关注的用户的id")})
    public JSONObject addFollowing(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "followingId") Integer followingId) {
        //二者的id必须不同才能关注
        if (userId.equals(followingId))
            return Result.error("两个id相同!");

        //如果已经在关注列表里面则不予执行
        QueryWrapper<bsFavorites> queryWrapper = new QueryWrapper<>();//构造条件查询器
        queryWrapper.eq("userFromId", userId);
        queryWrapper.eq("userToId", followingId);
        List<bsFavorites> bsFavoritesList = bsFavoritesService.list(queryWrapper);
        if (!bsFavoritesList.isEmpty())
            return Result.error("该用户已经在你的关注列表中!");

        //加入到关注列表
        bsFavorites bsFavorites = new bsFavorites();
        bsFavorites.setFavoriteId(null);
        bsFavorites.setUserFromId(userId);
        bsFavorites.setUserToId(followingId);
        bsFavoritesService.save(bsFavorites);
        return Result.ok("添加成功!");
    }

    @DeleteMapping("/deleteFollowing")
    @Operation(summary = "删除该用户的关注列表成员(用户--关注-->成员)")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "followingId", description = "关注的用户的id")})
    public JSONObject deleteFollowing(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "followingId") Integer followingId) {
        //二者的id必须不同才能关注
        if (userId.equals(followingId))
            return Result.error("两个id相同!");

        QueryWrapper<bsFavorites> queryWrapper = new QueryWrapper<>();//构造条件查询器
        queryWrapper.eq("userFromId", userId);
        queryWrapper.eq("UserToId", followingId);
        boolean deleteResult = bsFavoritesService.remove(queryWrapper);
        //根据返回值判断是否成功
        return deleteResult ? Result.ok("删除成功!") : Result.error("删除失败，要删除的用户根本就没在关注列表中!");
    }
}
