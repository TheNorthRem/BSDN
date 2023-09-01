package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("bs_userInformation")
@Schema(description = "用户信息")
public class bsUserInformation {
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户信息的主键")
    private Integer informationId;

    @TableField("userId")
    @Schema(description = "用户的主键")
    private Integer userId;

    @TableField("QQ")
    @Schema(description = "QQ号")
    private String QQ;

    @TableField("birthday")
    @Schema(description = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;

    @TableField("intro")
    @Schema(description = "留言")
    private String intro;

    @TableField("articleCount")
    @Schema(description = "发表文章数量")
    private Integer articleCount;

    @TableField("favoriteCount")
    @Schema(description = "关注数")
    private Integer favoriteCount;

    @TableField("clickCounts")
    @Schema(description = "点击数")
    private Integer clickCounts;

    @TableField(exist = false)
    @Schema(description = "用户名")
    private String userName;

    @TableField(exist = false)
    @Schema(description = "用户昵称")
    private String nickName;

    @TableField(exist = false)
    @Schema(description = "用户权限(0 普通用户 1管理员 2超级管理员) 管理员可审核文章及封禁用户 超级管理员能修改用户权限")
    private Integer privilege;

    @TableField(exist = false)
    @Schema(description = "头像对应的文件名（头像会上传到对应的文件夹用文件名唯一标识）")
    private String avatar;

    @TableField(exist = false)
    @Schema(description = "用户绑定的微信的openId")
    private String openId;
}
