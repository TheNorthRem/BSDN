package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsComments;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsCommentsMapper extends BaseMapper<bsComments> {
    @Select("select * from bs_comments where articleId = #{articleId} and fatherCommentId = -1 order by time")
    public List<bsComments> getFatherCommentsByArticle(Integer articleId);

    @Select("select * from bs_comments where fatherCommentId = #{fatherCommentId} order by time")
    public List<bsComments> getSonCommentsById(Integer fatherCommentId);

}
