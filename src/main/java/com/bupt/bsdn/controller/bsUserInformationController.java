package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.entity.bsUserInformation;
import com.bupt.bsdn.service.bsUserInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bupt.bsdn.service.bsUserService;


@RestController
@RequestMapping("/bsUserInformation")
@Slf4j
@Tag(name = "用户信息")
public class bsUserInformationController {
    private final bsUserInformationService bsUserInformationService;
    private final bsUserService bsUserService;
    @Autowired
    public bsUserInformationController(bsUserInformationService bsUserInformationService,
                                       bsUserService bsUserService) {
        this.bsUserInformationService = bsUserInformationService;
        this.bsUserService=bsUserService;
    }

    @GetMapping("/list")
    @Operation(summary = "获取全部用户信息")
    public JSONObject list() {
        return Result.ok(bsUserInformationService.list());
    }

    @PostMapping("/add")
    @Operation(summary = "增加用户信息")
    public JSONObject add(@RequestBody bsUserInformation bsUserInformation) {
        bsUserInformation.setInformationId(null);
        return Result.ok(bsUserInformationService.save(bsUserInformation));
    }

    @PostMapping("/edit")
    @Parameters({@Parameter(name = "informationId",description = "信息主键"),@Parameter(name = "intro",description = "简介"),
    @Parameter(name = "avatar" ,description = "头像"),@Parameter(name = "birthday",description = "生日"),
    @Parameter(name = "qq",description = "QQ"),@Parameter(name = "nickName" ,description = "昵称")

    })
    @Operation(summary = "修改用户信息")
    public JSONObject edit(@RequestBody JSONObject data) {
        Integer informationId = data.getInteger("informationId");
        bsUserInformation byId = bsUserInformationService.getById(informationId);
        if(byId==null){
            return Result.error("用户不存在");
        }
        byId.setIntro(data.getString("intro"));
//        byId.setBirthday(new Date(data.getString("birthday")));
        byId.setQQ(data.getString("qq"));
        bsUserInformationService.updateById(byId);
        bsUser byuser = bsUserService.getById(byId.getUserId());
        byuser.setAvatar(data.getString("avatar"));
        byuser.setNickName(data.getString("nickName"));
        bsUserService.updateById(byuser);
        return Result.ok("success");
    }

    @GetMapping("/getById")
    @Operation(summary = "根据id获取用户信息")
    public JSONObject getById(@RequestParam(name = "id") Integer id) {
        return Result.ok(bsUserInformationService.getById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "根据用户id搜索用户信息(详情页展示使用)")
    @Parameter(name = "userId",description = "用户id")
    public JSONObject search(@RequestParam(name = "userId") Integer userId) {
        return Result.ok(bsUserInformationService.search(userId));
    }
}
