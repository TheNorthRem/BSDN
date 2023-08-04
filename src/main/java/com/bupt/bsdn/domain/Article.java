package com.bupt.bsdn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName Article
 */
@TableName(value ="Article")
public class Article implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer articleId;

    /**
     * 
     */
    private Integer uploaderId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Integer clickCount;

    /**
     * 
     */
    private Integer favoriteCount;

    /**
     * 
     */
    private Object state;

    /**
     * 
     */
    private LocalDateTime uploadTime;

    /**
     * 
     */
    private String brief;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
    public Integer getUploaderId() {
        return uploaderId;
    }

    /**
     * 
     */
    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
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
    public String getTitle() {
        return title;
    }

    /**
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 
     */
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * 
     */
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * 
     */
    public Object getState() {
        return state;
    }

    /**
     * 
     */
    public void setState(Object state) {
        this.state = state;
    }

    /**
     * 
     */
    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    /**
     * 
     */
    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * 
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 
     */
    public void setBrief(String brief) {
        this.brief = brief;
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
        Article other = (Article) that;
        return (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getUploaderId() == null ? other.getUploaderId() == null : this.getUploaderId().equals(other.getUploaderId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getClickCount() == null ? other.getClickCount() == null : this.getClickCount().equals(other.getClickCount()))
            && (this.getFavoriteCount() == null ? other.getFavoriteCount() == null : this.getFavoriteCount().equals(other.getFavoriteCount()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getBrief() == null ? other.getBrief() == null : this.getBrief().equals(other.getBrief()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getUploaderId() == null) ? 0 : getUploaderId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getClickCount() == null) ? 0 : getClickCount().hashCode());
        result = prime * result + ((getFavoriteCount() == null) ? 0 : getFavoriteCount().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getBrief() == null) ? 0 : getBrief().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", uploaderId=").append(uploaderId);
        sb.append(", content=").append(content);
        sb.append(", title=").append(title);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", favoriteCount=").append(favoriteCount);
        sb.append(", state=").append(state);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", brief=").append(brief);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}