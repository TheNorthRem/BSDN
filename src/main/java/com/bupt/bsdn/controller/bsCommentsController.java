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
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "articleId", description = "文章Id"), @Parameter(name = "content", description = "文章内容"), @Parameter(name = "fatherCommentId", description = "父评论id(没有传null即可)")})
    public JSONObject uploadComment(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "articleId") Integer articleId, @RequestParam(name = "content") String content, @RequestParam(name = "fatherCommentId") Integer fatherCommentId) {
        if (content.trim().isEmpty()) {
            return Result.error("评论为空");
        }

        if (bsuserService.getById(userId) == null || bsarticleService.getById(articleId) == null) {
            Result.error("没有对应的用户/文章");
        }

        bsComments bsComments = new bsComments();
        bsComments.setUserID(userId);
        bsComments.setContent(content);
        bsComments.setArticleID(articleId);

        if (fatherCommentId != null)
            bsComments.setFatherCommentID(fatherCommentId);

        bsCommentsService.save(bsComments);

        return Result.ok("添加评论成功");
    }

    @GetMapping("/getComments")
    @Operation(summary = "获取文章的所有评论")
    @Parameters({@Parameter(name = "articleId", description = "文章Id"), @Parameter(name = "page", description = "第几页")})
    public JSONObject getComments(@RequestParam(value = "articleId") Integer article_id, @RequestParam(value = "page") Integer page) {
        return Result.ok(bsCommentsService.getArticleComments(article_id, page));
    }
}
