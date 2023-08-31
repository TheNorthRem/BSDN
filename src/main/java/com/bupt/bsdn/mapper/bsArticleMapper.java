package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.bsdn.entity.bsArticle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsArticleMapper extends BaseMapper<bsArticle> {
    @Select("select articleId, title, clickCount, favoriteCount, state, updateTime, brief, updateTime from bs_article order by bs_article.updateTime desc ")
    List<bsArticle> search(String content);
}
