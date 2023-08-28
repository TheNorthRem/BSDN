package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
@TableName("bs_history")
@Schema(name = "浏览历史")
public class bsHistory {
    @TableField("userId")
    @Schema(description = "浏览者的Id")
    private Integer userId;

    @TableField("articleId")
    @Schema(description = "浏览文章的Id")
    private Integer articleId;

    @TableField("time")
    @Schema(description = "浏览时间 如果 该用户在该文章中存在浏览记录 则更新访问时间 否则 插入")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
}
