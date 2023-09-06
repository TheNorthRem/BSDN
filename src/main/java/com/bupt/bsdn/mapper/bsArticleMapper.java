package com.bupt.bsdn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.entity.bsArticle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bsArticleMapper extends BaseMapper<bsArticle> {
    @Select("select bs_article.article_id as articleId," +
            " bs_article.uploaderId as uploaderId ," +
            " bs_article.brief as brief ," +
            " bs_article.title as title ," +
            " bs_article.clickCount as clickCount, " +
            " bs_article.favoriteCount as favoriteCount, " +
            " bs_article.uploadTime as uploadTime, " +
            " bs_article.category as category, " +
            " bs_user.nickName as nickName, " +
            " bs_user.avatar as avatar " +
            " from bs_article join bs_user on bs_article.uploaderId=bs_user.user_id where bs_article.title like concat('%', concat(#{Content}, '%'))" +
            "order by bs_article.clickCount desc ")
    Page<bsArticle> search(String Content, Page<bsArticle> page);

    @Select("select bs_article.article_id as articleId," +
            " bs_article.uploaderId as uploaderId," +
            "bs_article.brief as brief," +
            " bs_article.title as title ," +
            " bs_article.clickCount as clickCount, " +
            " bs_article.favoriteCount as favoriteCount, " +
            " bs_article.uploadTime as uploadTime, " +
            " bs_article.category as category, " +
            " bs_user.nickName as nickName, " +
            " bs_user.avatar as avatar " +
            " from bs_article join bs_user on bs_article.uploaderId=bs_user.user_id " +
            "where bs_article.title like concat('%', concat(#{content}, '%')) " +
            "or bs_article.content like concat('%', concat(#{content}, '%')) " +
            "or bs_article.brief like concat('%',concat(#{content}, '%')) " +
            "order by bs_article.clickCount desc ")
    Page<bsArticle> searchContent(String content, Page<bsArticle> page);

    @Select("select * from bs_article order by clickCount desc limit 5")
    List<bsArticle> getTopContent();

    @Select("select bs_article.article_id as articleId," +
            " bs_article.uploaderId as uploaderId," +
            "bs_article.brief as brief," +
            " bs_article.title as title ," +
            " bs_article.clickCount as clickCount, " +
            " bs_article.favoriteCount as favoriteCount, " +
            " bs_article.uploadTime as uploadTime, " +
            " bs_article.category as category, " +
            " bs_user.nickName as nickName, " +
            " bs_user.avatar as avatar " +
            " from bs_article join bs_user on bs_article.uploaderId=bs_user.user_id " +
            " where  bs_article.category=#{category}"
            )

    Page<bsArticle> searchByCategory(String category,Page<bsArticle> page);

}
