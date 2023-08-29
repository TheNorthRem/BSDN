package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.config.Result;
import com.bupt.bsdn.entity.bsArticle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.bsdn.service.bsArticleService;

import java.util.List;

@RestController
@RequestMapping("/bsArticle")
@Slf4j
@Tag(name = "文章")
public class bsArticleController {
    private final bsArticleService bsArticleService;

    @Autowired
    public bsArticleController(bsArticleService bsArticleService) {
        this.bsArticleService = bsArticleService;
    }

    @GetMapping("/list")
    @Operation(summary = "查询全部文章")
    public Result list() {
        return Result.ok((JSONObject) bsArticleService.list());
    }

    @PostMapping("/add")
    @Operation(summary = "增加文章")

    public Result add(@RequestBody bsArticle bsArticle) {
        bsArticle.setArticleId(null);
        return Result.ok(String.valueOf(bsArticleService.save(bsArticle)));
    }

    @PostMapping("/edit")
    @Operation(summary = "修改文章")
    public Boolean edit(@RequestBody bsArticle bsArticle) {
        return bsArticleService.updateById(bsArticle);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除文章")
    @Parameter(name="id",description = "文章Id")
    public Boolean delete(@RequestParam(name = "id") Integer id) {
        return bsArticleService.removeById(id);
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查询")
    @Parameter(name="id",description = "文章Id")
    public bsArticle getById(@RequestParam(name = "id") Integer id) {
        return bsArticleService.getById(id);
    }
}
