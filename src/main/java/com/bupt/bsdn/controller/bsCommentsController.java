package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.entity.bsComments;
import com.bupt.bsdn.service.bsCommentsService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Autowired
    public bsCommentsController(bsCommentsService bsCommentsService) {
        this.bsCommentsService = bsCommentsService;
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
}
