package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.entity.bsComments;
import com.bupt.bsdn.service.bsArticleService;
import com.bupt.bsdn.service.bsCommentsService;
import com.bupt.bsdn.service.bsUserService;
import com.bupt.bsdn.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bsComments")
@Slf4j
@Tag(name = "评论")
public class bsCommentsController {
    private final bsCommentsService bsCommentsService;
    private final bsUserService bsuserService;
    private final bsArticleService bsarticleService;

    @Autowired
    public bsCommentsController(bsCommentsService bsCommentsService, bsUserService bsuserService, bsArticleService bsarticleService) {
        this.bsCommentsService = bsCommentsService;
        this.bsuserService = bsuserService;
        this.bsarticleService = bsarticleService;
    }

    @GetMapping("/list")
    @Operation(summary = "获取全部评论")
    public JSONObject list() {
        return Result.ok(bsCommentsService.list());

    }

    @PostMapping("/add")
    @Operation(summary = "添加评论")
    public JSONObject add(@RequestBody bsComments bsComments) {
        bsComments.setCommentsId(null);
        return Result.ok(bsCommentsService.save(bsComments));
    }

    @PostMapping("/edit")
    @Operation(summary = "修改评论")
    public JSONObject edit(@RequestBody bsComments bsComments) {
        return Result.ok(bsCommentsService.updateById(bsComments));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除评论")
    public JSONObject delete(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsCommentsService.removeById(id));
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查询评论信息")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsCommentsService.getById(id));
    }

    @PostMapping("/uploadComment")
    @Operation(summary = "上传评论")
    public JSONObject uploadComment(@RequestBody JSONObject data) {

        Integer id = data.getInteger("id");
        Integer article_id = data.getInteger("articleId");
        String content = data.getString("content");
        Integer father_comment_id = data.getInteger("fatherCommentId");

        bsComments comments = new bsComments();

        if (content.trim().isEmpty()) {
            return Result.error("fail");
        }

        if (bsuserService.getById(id) == null || bsarticleService.getById(article_id) == null) {
            Result.error("fail");
        }

        comments.setUserID(id);
        comments.setContent(content);
        comments.setArticleID(article_id);

        if (father_comment_id != null) comments.setFatherCommentID(father_comment_id);

        bsCommentsService.save(comments);

        return Result.ok("success");
    }

    @GetMapping("/getComments")
    @Operation(summary = "获取文章的所有评论")
    @Parameters({@Parameter(name = "articleId", description = "文章Id"), @Parameter(name = "page", description = "第几页")})
    public JSONObject getComments(@RequestParam(value = "articleId") Integer article_id, @RequestParam(value = "page") Integer page) {
        return Result.ok(bsCommentsService.getArticleComments(article_id, page));
    }
}
