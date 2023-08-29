package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.config.Result;
import com.bupt.bsdn.entity.bsMessage;
import com.bupt.bsdn.service.bsMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bsMessage")
@Slf4j
@Tag(name = "消息")
public class bsMessageController {
    private final bsMessageService bsMessageService;

    @Autowired
    public bsMessageController(bsMessageService bsMessageService) {
        this.bsMessageService = bsMessageService;
    }

    @GetMapping("/list")
    @Operation(summary = "获取全部消息")
    public JSONObject list() {
        return Result.ok(bsMessageService.list()) ;
    }

    @PostMapping("/add")
    @Operation(summary = "增加消息")
    public JSONObject add(@RequestBody bsMessage bsMessage) {
        bsMessage.setMessageId(null);
        return Result.ok(bsMessageService.save(bsMessage))  ;
    }

    @PostMapping("/edit")
    @Operation(summary = "修改消息")
    public JSONObject edit(@RequestBody bsMessage bsMessage) {
        return Result.ok(bsMessageService.updateById(bsMessage)) ;
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除消息")
    public JSONObject delete(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsMessageService.removeById(id)) ;
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查找消息")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsMessageService.getById(id)) ;
    }
}
