package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("bs_favorites")
@Schema(name = "收藏")

public class bsFavorites {
    @TableField("userFromId")
    @Schema(description = "关注者的ID")
    private Integer userFromId;

    @TableField("userToId")
    @Schema(description = "被关注着的ID")
    private Integer userToId;

}
