package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsArticle;

import java.util.List;

public interface bsArticleService extends IService<bsArticle> {
    Page<bsArticle> search(String content,Integer page);

    Page<bsArticle> searchContent(String content, Integer page);

    Page<bsArticle> searchByCategory(String category, Integer page);
    List<bsArticle> getTopArticle();

    List<bsArticle> getArticlesByUserId(Integer userId);

    List<bsArticle> getFavoriteArticles(Integer userId);
}
