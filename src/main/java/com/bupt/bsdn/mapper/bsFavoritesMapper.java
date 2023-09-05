package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsFavorites;
import com.bupt.bsdn.entity.bsUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsFavoritesMapper extends BaseMapper<bsFavorites> {
    @Select("select bs_user.user_id as user_id, " +
            "bs_user.userName as userName, " +
            "bs_user.nickName as nickName, " +
            "bs_user.privilege as privilege, " +
            "bs_user.avatar as avatar, " +
            "bs_user.openId as openId " +
            "from (select * from bs_favorites where bs_favorites.userToId = #{id}) as favorites " +
            "join bs_user on favorites.userFromId = bs_user.user_id")
    List<bsUser> followers(Integer id);

    @Select("select bs_user.user_id as user_id, " +
            "bs_user.userName as userName, " +
            "bs_user.nickName as nickName, " +
            "bs_user.privilege as privilege, " +
            "bs_user.avatar as avatar, " +
            "bs_user.openId as openId " +
            "from (select * from bs_favorites where bs_favorites.userFromId = #{id}) as favorites " +
            "join bs_user on favorites.userToId = bs_user.user_id")
    List<bsUser> following(Integer id);
}
