package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.config.Result;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.service.bsArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JSONObject list() {
        return Result.ok(bsArticleService.list());
    }

    @PostMapping("/add")
    @Operation(summary = "增加文章")
    public JSONObject add(@RequestBody bsArticle bsArticle) {
        bsArticle.setArticleId(null);
        return Result.ok(bsArticleService.save(bsArticle));
    }

    @PostMapping("/edit")
    @Operation(summary = "修改文章")
    public JSONObject edit(@RequestBody bsArticle bsArticle) {
        return Result.ok(bsArticleService.updateById(bsArticle));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除文章")
    @Parameter(name = "id", description = "文章Id")
    public JSONObject delete(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsArticleService.removeById(id));
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查询")
    @Parameter(name = "id", description = "文章Id")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsArticleService.getById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "搜索文章(模糊查询+时间戳倒叙)")
    @Parameter(name = "content", description = "内容")
    public JSONObject search(@RequestParam(name = "content") String content) {
        return Result.ok(bsArticleService.search(content));
    }
}
