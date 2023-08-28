package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bs_userInformation")
@Schema(description = "用户信息")
public class bsUserInformation {
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户的主键")
    private Integer userId;

    @TableField("QQ")
    @Schema(description = "QQ号")
    private String QQ;

    @TableField("birthday")
    @Schema(description = "生日")
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
}
