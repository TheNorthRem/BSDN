package com.bupt.bsdn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("bs_user")
@Schema(description = "用户")
public class bsUser {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer userId;

    @TableField("userName")
    @Schema(description = "用户名")
    private String userName;

    @TableField("nickName")
    @Schema(description = "用户昵称")
    private String nickName;

    @TableField("password")
    @Schema(description = "密码")
    private String password;

    @TableField("privilege")
    @Schema(description = "用户权限(0 普通用户 1管理员 2超级管理员) 管理员可审核文章及封禁用户 超级管理员能修改用户权限")
    private Integer privilege;

    @TableField("avatar")
    @Schema(description = "头像对应的文件名（头像会上传到对应的文件夹用文件名唯一标识）")
    private String avatar;

    @TableField("openId")
    @Schema(description = "用户绑定的微信的openId")
    private Integer openId;
}
