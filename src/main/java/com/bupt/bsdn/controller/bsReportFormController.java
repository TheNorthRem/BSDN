package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.entity.bsReportForm;
import com.bupt.bsdn.service.bsReportFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bsReportForm")
@Slf4j
@Tag(name = "举报表")
public class bsReportFormController {
    private final bsReportFormService bsReportFormService;

    @Autowired
    public bsReportFormController(bsReportFormService bsReportFormService) {
        this.bsReportFormService = bsReportFormService;
    }

    @GetMapping("/list")
    @Operation(summary = "查询全部举报表")
    public JSONObject list() {
        return Result.ok(bsReportFormService.list());
    }

    @PostMapping("/add")
    @Operation(summary = "增加举报表")
    public JSONObject add(@RequestBody bsReportForm bsReportForm) {
        bsReportForm.setReportId(null);
        return Result.ok(bsReportFormService.save(bsReportForm));
    }

    @PostMapping("/edit")
    @Operation(summary = "修改举报表内容")
    public JSONObject edit(@RequestBody bsReportForm bsReportForm) {
        return Result.ok(bsReportFormService.updateById(bsReportForm));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除举报表")
    public JSONObject delete(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsReportFormService.removeById(id));
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查询举报表")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsReportFormService.getById(id));
    }
}
