package com.bupt.bsdn.controller;

import com.bupt.bsdn.entity.bsMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.bsdn.service.bsMessageService;

import java.util.List;

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
    public List<bsMessage> list() {
        return bsMessageService.list();
    }

    @PostMapping("/add")
    @Operation(summary = "增加消息")
    public Boolean add(@RequestBody bsMessage bsMessage) {
        bsMessage.setMessageId(null);
        return bsMessageService.save(bsMessage);
    }

    @PostMapping("/edit")
    @Operation(summary = "修改消息")
    public Boolean edit(@RequestBody bsMessage bsMessage) {
        return bsMessageService.updateById(bsMessage);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除消息")
    public Boolean delete(@RequestParam(name = "id") Integer id) {
        return bsMessageService.removeById(id);
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查找消息")
    public bsMessage getById(@RequestParam(name = "id") Integer id) {
        return bsMessageService.getById(id);
    }
}
