package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsUserInformation;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface bsUserInformationMapper extends BaseMapper<bsUserInformation> {
    @Select("select bs_userInformation.information_id as information_id, " +
            "       bs_user.user_id                   as user_id, " +
            "       bs_userInformation.QQ             as QQ, " +
            "       bs_userInformation.birthday       as birthday, " +
            "       bs_userInformation.intro          as intro, " +
            "       bs_userInformation.articleCount   as articleCount, " +
            "       bs_userInformation.favoriteCount  as favoriteCount, " +
            "       bs_userInformation.clickCounts    as clickCounts, " +
            "       bs_user.userName                  as userName, " +
            "       bs_user.nickName                  as nickName, " +
            "       bs_user.privilege                 as privilege, " +
            "       bs_user.avatar                    as avatar, " +
            "       bs_user.openId                    as openId " +
            "from bs_userInformation " +
            "join bs_user on bs_userInformation.userId = bs_user.user_id " +
            "where bs_user.user_id = #{userId} " +
            "order by bs_user.privilege "
    )
    List<bsUserInformation> search(Integer userId);

}
