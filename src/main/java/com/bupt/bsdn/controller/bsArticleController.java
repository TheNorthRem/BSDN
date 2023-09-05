package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.service.bsArticleService;
import com.bupt.bsdn.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

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

    @PostMapping("/upload")
    @Operation(summary = "上传文章")
    @Parameter(name = "article", description = """
            前端需要传入
                  title 标题
                  content 内容
                  brief 简介
                  id 用户ID""")
    public JSONObject upload(@RequestBody JSONObject article) {

        bsArticle bs_article = new bsArticle();

        bs_article.setArticleId(null);

        String title = article.getString("title");
        String content = article.getString("content");
        Integer uploaderId = article.getInteger("id");

        if (uploaderId == null) {
            return Result.error("id is null!");
        }

        if (title == null || title.length() >= 100 || title.trim().isEmpty()) {
            return Result.error("标题不合规");
        }


        bs_article.setUploaderId(uploaderId);
        bs_article.setTitle(title);
        bs_article.setContent(content);
        bs_article.setCategory("孙吧风味");
        String brief = content.replaceAll("<.+?>", "");
        brief = brief.length() < 200 ? brief : brief.substring(0, 200);
        bs_article.setBrief(brief);

        if (bsArticleService.save(bs_article)) {
            log.info(bs_article.getArticleId() + "上传成功-----" + bs_article.getUploadTime());
            return Result.ok("success");
        }

        log.info("上传失败-----" + bs_article.getUploadTime());


        return Result.error("上传失败");
    }

    @PostMapping("/edit")
    @Operation(summary = "修改文章")
    public JSONObject edit(@RequestBody bsArticle bsArticle) {
        bsArticle.setUpdateTime(new Timestamp(new Date().getTime()));
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
    @Operation(summary = "搜索文章(模糊查询+收藏量倒序)")
    @Parameters({@Parameter(name = "content", description = "搜索内容"), @Parameter(name = "page", description = "第几页")})
    public JSONObject search(@RequestParam(name = "content") String content, @RequestParam(name = "page") Integer page) {
        Page<bsArticle> search = bsArticleService.search(content, page);
        return Result.ok(search);
    }

    @GetMapping("/searchContent")
    @Operation(summary = "搜索文章(模糊查询+收藏量倒序),只要标题或内容模糊查询匹配即可,该接口自带分页功能")
    @Parameters({@Parameter(name = "content", description = "搜索内容"), @Parameter(name = "page", description = "第几页")})
    public JSONObject searchContent(@RequestParam(name = "content") String content, @RequestParam(name = "page") Integer page) {
        Page<bsArticle> search = bsArticleService.searchContent(content, page);
        return Result.ok(search);
    }

    @GetMapping("getTopArticles")
    @Operation(summary = "获取热门文章")
    public JSONObject getTopArticle() {
        return Result.ok(bsArticleService.getTopArticle());
    }
}
