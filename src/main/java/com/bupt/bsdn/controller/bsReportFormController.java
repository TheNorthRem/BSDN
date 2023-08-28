package com.bupt.bsdn.controller;


import com.bupt.bsdn.entity.bsReportForm;
import com.bupt.bsdn.service.bsReportFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<bsReportForm> list() {
        return bsReportFormService.list();
    }

    @PostMapping("/add")
    @Operation(summary = "增加举报表")
    public Boolean add(@RequestBody bsReportForm bsReportForm) {
        bsReportForm.setReportId(null);
        return bsReportFormService.save(bsReportForm);
    }

    @PostMapping("/edit")
    @Operation(summary = "修改举报表内容")
    public Boolean edit(@RequestBody bsReportForm bsReportForm) {
        return bsReportFormService.updateById(bsReportForm);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除举报表")
    public Boolean delete(@RequestParam(name = "id") Integer id) {
        return bsReportFormService.removeById(id);
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id查询举报表")
    public bsReportForm getById(@RequestParam(name = "id") Integer id) {
        return bsReportFormService.getById(id);
    }
}
