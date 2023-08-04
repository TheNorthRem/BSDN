package com.bupt.bsdn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName Comments
 */
@TableName(value ="Comments")
public class Comments implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer commentsId;

    /**
     * 
     */
    private Integer articleId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String content;

    /**
     * the comments which this comment reply to
     */
    private Integer fatherCommentsId;

    /**
     * 
     */
    private LocalDateTime time;

    /**
     * 
     */
    private Integer favorCount;

    /**
     * 
     */
    private Integer unfavorCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getCommentsId() {
        return commentsId;
    }

    /**
     * 
     */
    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    /**
     * 
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * the comments which this comment reply to
     */
    public Integer getFatherCommentsId() {
        return fatherCommentsId;
    }

    /**
     * the comments which this comment reply to
     */
    public void setFatherCommentsId(Integer fatherCommentsId) {
        this.fatherCommentsId = fatherCommentsId;
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

    /**
     * 
     */
    public Integer getFavorCount() {
        return favorCount;
    }

    /**
     * 
     */
    public void setFavorCount(Integer favorCount) {
        this.favorCount = favorCount;
    }

    /**
     * 
     */
    public Integer getUnfavorCount() {
        return unfavorCount;
    }

    /**
     * 
     */
    public void setUnfavorCount(Integer unfavorCount) {
        this.unfavorCount = unfavorCount;
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
        Comments other = (Comments) that;
        return (this.getCommentsId() == null ? other.getCommentsId() == null : this.getCommentsId().equals(other.getCommentsId()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getFatherCommentsId() == null ? other.getFatherCommentsId() == null : this.getFatherCommentsId().equals(other.getFatherCommentsId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getFavorCount() == null ? other.getFavorCount() == null : this.getFavorCount().equals(other.getFavorCount()))
            && (this.getUnfavorCount() == null ? other.getUnfavorCount() == null : this.getUnfavorCount().equals(other.getUnfavorCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentsId() == null) ? 0 : getCommentsId().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getFatherCommentsId() == null) ? 0 : getFatherCommentsId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getFavorCount() == null) ? 0 : getFavorCount().hashCode());
        result = prime * result + ((getUnfavorCount() == null) ? 0 : getUnfavorCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentsId=").append(commentsId);
        sb.append(", articleId=").append(articleId);
        sb.append(", userId=").append(userId);
        sb.append(", content=").append(content);
        sb.append(", fatherCommentsId=").append(fatherCommentsId);
        sb.append(", time=").append(time);
        sb.append(", favorCount=").append(favorCount);
        sb.append(", unfavorCount=").append(unfavorCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}