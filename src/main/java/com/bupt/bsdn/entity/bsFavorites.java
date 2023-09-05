package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("bs_favorites")
@Schema(name = "关注")

public class bsFavorites {
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer favoriteId;

    @TableField("userFromId")
    @Schema(description = "关注者的ID")
    private Integer userFromId;

    @TableField("userToId")
    @Schema(description = "被关注着的ID")
    private Integer userToId;
}
