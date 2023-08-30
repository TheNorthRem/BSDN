package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface bsUserMapper extends BaseMapper<bsUser> {

    /**
     * 通过用户名获取到用户对象
     */

    @Select("select * from bs_user where userName=#{username}")
    bsUser getUserByUsername(String username);
}
