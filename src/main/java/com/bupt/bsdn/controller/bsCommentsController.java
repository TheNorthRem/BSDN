package com.bupt.bsdn.controller;


import com.bupt.bsdn.entity.bsComments;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.bsdn.service.bsCommentsService;

import java.util.List;

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
    public List<bsComments> list() {
        return bsCommentsService.list();
    }

    @PostMapping("/add")
    @Operation(summary = "添加评论")
    public Boolean add(@RequestBody bsComments bsComments) {
        bsComments.setCommentsId(null);
        return bsCommentsService.save(bsComments);
    }

    @PostMapping("/edit")
    @Operation(summary = "修改评论")
    public Boolean edit(@RequestBody bsComments bsComments) {
        return bsCommentsService.updateById(bsComments);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除评论")
    public Boolean delete(@RequestParam(name = "id") Integer id) {
        return bsCommentsService.removeById(id);
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查询评论信息")
    public bsComments getById(@RequestParam(name = "id") Integer id) {
        return bsCommentsService.getById(id);
    }
}
