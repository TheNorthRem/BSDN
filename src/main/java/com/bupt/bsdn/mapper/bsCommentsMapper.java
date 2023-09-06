package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.entity.bsComments;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsCommentsMapper extends BaseMapper<bsComments> {
    @Select("select * from bs_comments where articleId = #{articleId} and fatherCommentId = -1 order by time")
    List<bsComments> getFatherCommentsByArticle(Integer articleId);

    @Select("select comments_id, " +
            "       articleId, " +
            "       user_id, " +
            "       content, " +
            "       time, " +
            "       fatherCommentId, " +
            "       userName, " +
            "       nickName, " +
            "       privilege, " +
            "       avatar, " +
            "       openId " +
            "from bs_comments " +
            "         join bs_user on bs_comments.userId = bs_user.user_id " +
            "where articleId = #{articleId} " +
            "order by time desc")
    Page<bsComments> getArticleComments(Integer articleId, Page<bsComments> page);
}
