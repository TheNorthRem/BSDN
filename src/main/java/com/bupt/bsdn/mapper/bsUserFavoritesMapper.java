package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsUserFavorites;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsUserFavoritesMapper extends BaseMapper<bsUserFavorites> {
    @Select("select * from bs_userFavorites where userId=#{userId}")
    List<bsUserFavorites> getByUserId(Integer userId);
}
