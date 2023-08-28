package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
@TableName("bs_article")
@Schema(name = "文章")
public class bsArticle {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer articleId;

    @TableField("uploaderId")
    @Schema(description = "上传者的ID")
    private Integer uploaderId;

    @TableField("content")
    @Schema(description = "文章内容")
    private String content;

    @TableField("title")
    @Schema(description = "文章标题")
    private String title;

    @TableField("clickCount")
    @Schema(description = "点击量")
    private Integer clickCount;

    @TableField("favoriteCount")
    @Schema(description = "收藏量")
    private Integer favoriteCount;

    @TableField("state")
    @Schema(description = "文章的状态 1 审核通过 2 未通过 3 待审核")
    private Integer state;

    @TableField("uploadTime")
    @Schema(description = "文章上传时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp uploadTime;

    @TableField("brief")
    @Schema(description = "文章简介")
    private String brief;

    @TableField("checkMessage")
    @Schema(description = "审核意见")
    private String checkMessage;

    @TableField("updateTime")
    @Schema(description = "更新（修改） 时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;
}
