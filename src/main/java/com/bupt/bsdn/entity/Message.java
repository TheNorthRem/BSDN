package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName Message
 */
@TableName(value ="Message")
public class Message implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer messageId;

    /**
     * 
     */
    private Integer userFromId;

    /**
     * 
     */
    private Integer userToId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private LocalDateTime time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * 
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * 
     */
    public Integer getUserFromId() {
        return userFromId;
    }

    /**
     * 
     */
    public void setUserFromId(Integer userFromId) {
        this.userFromId = userFromId;
    }

    /**
     * 
     */
    public Integer getUserToId() {
        return userToId;
    }

    /**
     * 
     */
    public void setUserToId(Integer userToId) {
        this.userToId = userToId;
    }

    /**
     * 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * 
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Message other = (Message) that;
        return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
            && (this.getUserFromId() == null ? other.getUserFromId() == null : this.getUserFromId().equals(other.getUserFromId()))
            && (this.getUserToId() == null ? other.getUserToId() == null : this.getUserToId().equals(other.getUserToId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getUserFromId() == null) ? 0 : getUserFromId().hashCode());
        result = prime * result + ((getUserToId() == null) ? 0 : getUserToId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", userFromId=").append(userFromId);
        sb.append(", userToId=").append(userToId);
        sb.append(", content=").append(content);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}