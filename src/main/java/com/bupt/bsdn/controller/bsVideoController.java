package com.bupt.bsdn.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.util.Utils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/VideoUpload")
@Slf4j
@Tag(name = "视频上传")
public class bsVideoController {
    @RequestMapping
    public JSONObject videoUpload(@RequestParam(value = "video") MultipartFile file) throws IOException {
        String path = Utils.getParamSettings("videoPath");

        Calendar instance = Calendar.getInstance();
        String month = (instance.get(Calendar.MONTH) + 1) + "月";
        path += month;

        File realPath = new File(path);
        if (!realPath.exists())
            realPath.mkdirs();

        log.info("上传文件保存地址");
        String format = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf('.'));

        //解决文件名字问题：我们使用uuid;
        String filename = "pg-" + UUID.randomUUID().toString().replaceAll("-", "") + format;
        File newfile = new File(realPath, filename);
        file.transferTo(newfile);
        String uploadPath = "/video/upload/" + month + "/" + filename;

        JSONObject result = new JSONObject();
        result.put("errno", 0);
        JSONObject data = new JSONObject();
        data.put("url", Utils.getParamSettings("BaseUrl") + uploadPath);
        result.put("data", data);
        log.info("----" + result + "-------");

        return result;
    }
}
