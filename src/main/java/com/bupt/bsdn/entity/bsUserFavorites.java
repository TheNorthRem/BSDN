package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("bs_userFavorites")
@Schema(name = "用户收藏的文章")
public class bsUserFavorites {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    @TableField("userId")
    @Schema(description = "用户id")
    private Integer userId;

    @TableField("articleId")
    @Schema(description = "用户收藏的文章id")
    private Integer articleId;
}
