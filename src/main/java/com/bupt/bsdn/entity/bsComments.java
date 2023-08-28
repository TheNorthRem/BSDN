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
@TableName("bs_comments")
@Schema(name = "评论")
public class bsComments {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer commentsID;

    @TableField("articleID")
    @Schema(description = "回复文章的ID")
    private Integer articleID;

    @TableField("userID")
    @Schema(description = "评论者的ID")
    private Integer userID;

    @TableField("content")
    @Schema(description = "评论内容")
    private String content;

    @TableField("time")
    @Schema(description = "评论时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @TableField("fatherCommentID")
    @Schema(description = "回复的父评论ID,若是直接对文章进行回复,则父评论ID可为空或占位符")
    private Integer fatherCommentID;
}
