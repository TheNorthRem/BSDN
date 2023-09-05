package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsUserMapper extends BaseMapper<bsUser> {

    /**
     * 通过用户名获取到用户对象
     */

    @Select("select * from bs_user where userName=#{username}")
    bsUser getUserByUsername(String username);

    @Select("select bs_user.user_id as user_id, " +
            "bs_user.userName as userName, " +
            "bs_user.nickName as nickName, " +
            "bs_user.privilege as privilege, " +
            "bs_user.avatar as avatar, " +
            "bs_user.openId as openId " +
            "from bs_user " +
            "where bs_user.userName like concat('%', concat(#{userName}, '%')) " +
            "order by bs_user.privilege")
    List<bsUser> search(String userName);

    @Select("select bs_user.user_id as user_id, " +
            "bs_user.userName as userName, " +
            "bs_user.nickName as nickName, " +
            "bs_user.privilege as privilege, " +
            "bs_user.avatar as avatar, " +
            "bs_user.openId as openId, " +
            "bs_userInformation.intro as intro " +
            "from bs_user join bs_userInformation on bs_user.user_id=bs_userInformation.userId " +
            "where user_id=#{id} ")
    bsUser getUserDetailById(Integer Id);
}
