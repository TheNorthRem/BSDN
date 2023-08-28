package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsUserMapper extends BaseMapper<bsUser> {
    @Select("select * from bs_user limit 5")
    List<bsUser> selectFive();
}
