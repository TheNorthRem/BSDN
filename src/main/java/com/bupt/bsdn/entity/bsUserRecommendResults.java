package com.bupt.bsdn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("bs_user_recommend_results")
@Schema(name = "推荐结果")
public class bsUserRecommendResults {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    @TableField("user_id")
    @Schema(description = "用户id")
    private Integer userId;

    @TableField("recommend_results")
    @Schema(description = "推荐结果")
    private String recommendResults;
}
