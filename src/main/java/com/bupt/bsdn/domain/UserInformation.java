package com.bupt.bsdn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @TableName User_Information
 */
@TableName(value ="User_Information")
public class UserInformation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer uiId;

    /**
     * 
     */
    private String uiQq;

    /**
     * 
     */
    private LocalDate uiBirth;

    /**
     * 
     */
    private String uiIntro;

    /**
     * 
     */
    private Integer uiArticleCount;

    /**
     * 
     */
    private Integer uiFavoritesCount;

    /**
     * 
     */
    private Integer uiFansCount;

    /**
     * 
     */
    private Integer uiClickCount;

    /**
     * 
     */
    private Integer uiUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getUiId() {
        return uiId;
    }

    /**
     * 
     */
    public void setUiId(Integer uiId) {
        this.uiId = uiId;
    }

    /**
     * 
     */
    public String getUiQq() {
        return uiQq;
    }

    /**
     * 
     */
    public void setUiQq(String uiQq) {
        this.uiQq = uiQq;
    }

    /**
     * 
     */
    public LocalDate getUiBirth() {
        return uiBirth;
    }

    /**
     * 
     */
    public void setUiBirth(LocalDate uiBirth) {
        this.uiBirth = uiBirth;
    }

    /**
     * 
     */
    public String getUiIntro() {
        return uiIntro;
    }

    /**
     * 
     */
    public void setUiIntro(String uiIntro) {
        this.uiIntro = uiIntro;
    }

    /**
     * 
     */
    public Integer getUiArticleCount() {
        return uiArticleCount;
    }

    /**
     * 
     */
    public void setUiArticleCount(Integer uiArticleCount) {
        this.uiArticleCount = uiArticleCount;
    }

    /**
     * 
     */
    public Integer getUiFavoritesCount() {
        return uiFavoritesCount;
    }

    /**
     * 
     */
    public void setUiFavoritesCount(Integer uiFavoritesCount) {
        this.uiFavoritesCount = uiFavoritesCount;
    }

    /**
     * 
     */
    public Integer getUiFansCount() {
        return uiFansCount;
    }

    /**
     * 
     */
    public void setUiFansCount(Integer uiFansCount) {
        this.uiFansCount = uiFansCount;
    }

    /**
     * 
     */
    public Integer getUiClickCount() {
        return uiClickCount;
    }

    /**
     * 
     */
    public void setUiClickCount(Integer uiClickCount) {
        this.uiClickCount = uiClickCount;
    }

    /**
     * 
     */
    public Integer getUiUserId() {
        return uiUserId;
    }

    /**
     * 
     */
    public void setUiUserId(Integer uiUserId) {
        this.uiUserId = uiUserId;
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
        UserInformation other = (UserInformation) that;
        return (this.getUiId() == null ? other.getUiId() == null : this.getUiId().equals(other.getUiId()))
            && (this.getUiQq() == null ? other.getUiQq() == null : this.getUiQq().equals(other.getUiQq()))
            && (this.getUiBirth() == null ? other.getUiBirth() == null : this.getUiBirth().equals(other.getUiBirth()))
            && (this.getUiIntro() == null ? other.getUiIntro() == null : this.getUiIntro().equals(other.getUiIntro()))
            && (this.getUiArticleCount() == null ? other.getUiArticleCount() == null : this.getUiArticleCount().equals(other.getUiArticleCount()))
            && (this.getUiFavoritesCount() == null ? other.getUiFavoritesCount() == null : this.getUiFavoritesCount().equals(other.getUiFavoritesCount()))
            && (this.getUiFansCount() == null ? other.getUiFansCount() == null : this.getUiFansCount().equals(other.getUiFansCount()))
            && (this.getUiClickCount() == null ? other.getUiClickCount() == null : this.getUiClickCount().equals(other.getUiClickCount()))
            && (this.getUiUserId() == null ? other.getUiUserId() == null : this.getUiUserId().equals(other.getUiUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUiId() == null) ? 0 : getUiId().hashCode());
        result = prime * result + ((getUiQq() == null) ? 0 : getUiQq().hashCode());
        result = prime * result + ((getUiBirth() == null) ? 0 : getUiBirth().hashCode());
        result = prime * result + ((getUiIntro() == null) ? 0 : getUiIntro().hashCode());
        result = prime * result + ((getUiArticleCount() == null) ? 0 : getUiArticleCount().hashCode());
        result = prime * result + ((getUiFavoritesCount() == null) ? 0 : getUiFavoritesCount().hashCode());
        result = prime * result + ((getUiFansCount() == null) ? 0 : getUiFansCount().hashCode());
        result = prime * result + ((getUiClickCount() == null) ? 0 : getUiClickCount().hashCode());
        result = prime * result + ((getUiUserId() == null) ? 0 : getUiUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uiId=").append(uiId);
        sb.append(", uiQq=").append(uiQq);
        sb.append(", uiBirth=").append(uiBirth);
        sb.append(", uiIntro=").append(uiIntro);
        sb.append(", uiArticleCount=").append(uiArticleCount);
        sb.append(", uiFavoritesCount=").append(uiFavoritesCount);
        sb.append(", uiFansCount=").append(uiFansCount);
        sb.append(", uiClickCount=").append(uiClickCount);
        sb.append(", uiUserId=").append(uiUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}