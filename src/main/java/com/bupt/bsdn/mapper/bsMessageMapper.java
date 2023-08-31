package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsMessage;
import com.bupt.bsdn.entity.bsUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsMessageMapper extends BaseMapper<bsMessage> {
    @Select("select bs_user.user_id as user_id, " +
            "bs_user.userName as userName," +
            "bs_user.nickName as nickName," +
            "bs_user.privilege as privilege," +
            "bs_user.avatar as avatar," +
            "bs_user.openId as openId " +
            "from bs_message join bs_user on bs_message.userFromId = bs_user.user_id " +
            "where bs_message.userToId = #{userId}")
    List<bsUser> searchSendUser(Integer userId);

    @Select("select * " +
            "from bs_message " +
            "where bs_message.userFromId = #{userFromId} " +
            "&& bs_message.userToId = #{userToId} " +
            "order by bs_message.time")
    List<bsMessage> searchMessage(Integer userFromId, Integer userToId);
}
