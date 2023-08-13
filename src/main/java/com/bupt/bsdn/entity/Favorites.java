package com.bupt.bsdn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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

    private Integer userTargetId;

    /**
     * 
     */

    private Integer userSelfId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        return (this.getUserTargetId() == null ? other.getUserTargetId() == null : this.getUserTargetId().equals(other.getUserTargetId()))
            && (this.getUserSelfId() == null ? other.getUserSelfId() == null : this.getUserSelfId().equals(other.getUserSelfId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserTargetId() == null) ? 0 : getUserTargetId().hashCode());
        result = prime * result + ((getUserSelfId() == null) ? 0 : getUserSelfId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userTargetId=").append(userTargetId);
        sb.append(", userSelfId=").append(userSelfId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}