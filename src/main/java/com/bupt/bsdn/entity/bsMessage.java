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
import java.time.LocalDateTime;

@Data
@TableName("bs_message")
@Schema(description = "消息")
public class bsMessage {

    public bsMessage(){
        this.setTime(Timestamp.valueOf(LocalDateTime.now()));
    }

    @TableId(type = IdType.AUTO)
    @Schema(description = "消息的主键")
    private Integer messageId;

    @TableField("userFromId")
    @Schema(description = "发出消息者的Id")
    private Integer userFromId;

    @TableField("userToId")
    @Schema(description = "接受消息者的Id")
    private Integer userToId;

    @TableField("content")
    @Schema(description = "消息内容")
    private String content;

    @TableField("time")
    @Schema(description = "消息发送时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;

    @TableField(exist = false)
    @Schema( description = "发送者的nickName")
    private String nickName;

    @TableField(exist = false)
    @Schema(description = "发送者的头像")

    private  String avatar;
}
