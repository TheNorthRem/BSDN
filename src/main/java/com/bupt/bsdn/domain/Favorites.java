package com.bupt.bsdn.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName Favorites
 */
@TableName(value ="Favorites")
public class Favorites implements Serializable {
    /**
     * 
     */
    private Integer userSelfId;

    /**
     * 
     */
    private Integer userTargetId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getUserSelfId() {
        return userSelfId;
    }

    /**
     * 
     */
    public void setUserSelfId(Integer userSelfId) {
        this.userSelfId = userSelfId;
    }

    /**
     * 
     */
    public Integer getUserTargetId() {
        return userTargetId;
    }

    /**
     * 
     */
    public void setUserTargetId(Integer userTargetId) {
        this.userTargetId = userTargetId;
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
        Favorites other = (Favorites) that;
        return (this.getUserSelfId() == null ? other.getUserSelfId() == null : this.getUserSelfId().equals(other.getUserSelfId()))
            && (this.getUserTargetId() == null ? other.getUserTargetId() == null : this.getUserTargetId().equals(other.getUserTargetId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserSelfId() == null) ? 0 : getUserSelfId().hashCode());
        result = prime * result + ((getUserTargetId() == null) ? 0 : getUserTargetId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userSelfId=").append(userSelfId);
        sb.append(", userTargetId=").append(userTargetId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}