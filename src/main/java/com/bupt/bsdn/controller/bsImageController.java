package com.bupt.bsdn.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.util.Utils;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@RestController
@RequestMapping("/ImageUpload")
@Slf4j
@Tag(name = "图片上传")
public class bsImageController {
    @RequestMapping
    public JSONObject imageUpload(@RequestParam(value = "image", required = true) MultipartFile file) throws IOException {

            String path = Utils.getParamSettings("imagePath")+"upload//";

            Calendar instance = Calendar.getInstance();
            String month = (instance.get(Calendar.MONTH) + 1)+"月";
            path = path+month;

            File realPath = new File(path);
            if (!realPath.exists()){
                realPath.mkdirs();
            }
            //上传文件地址
            log.info("上传文件保存地址："+realPath);
            //解决文件名字问题：我们使用uuid;
            String filename = "pg-"+ UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
            File newfile = new File(realPath, filename);
            file.transferTo(newfile);

            String uploadPath="/image/upload/"+month+"/"+filename;
            JSONObject result=new JSONObject();
            result.put("errno",0);
            JSONObject data=new JSONObject();
            data.put("url",Utils.getParamSettings("BaseUrl")+uploadPath);
            result.put("data",data);
            System.out.println("----"+result+"-------");

            return result;
    }

}
