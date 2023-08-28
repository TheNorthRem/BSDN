package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@TableName("bs_reportform")
@Schema(description = "举报表")
public class bsReportForm {
    @TableId(type = IdType.AUTO)
    @Schema(description = "举报表的主键")
    private int reportId;
    @TableField("reportUserId")
    @Schema(description = "举报者的Id")
    private Integer reportUserId;

    @TableField("reportTargetArticle")
    @Schema(description = "举报内容所在文章的Id")
    private Integer reportTargetArticle;

    @TableField("reportTargetComment")
    @Schema(description = "举报的评论ID 若直接举报的为文章则可以为空")
    private Integer reportTargetComment;

    @TableField("reportReason")
    @Schema(description = "举报的理由")
    private String reportReason;

    @TableField("time")
    @Schema(description = "举报的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer userFromId;
}
