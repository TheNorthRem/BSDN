package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsArticle;

import java.util.List;

public interface bsArticleService extends IService<bsArticle> {
    List<bsArticle> search(String content);

    Page<bsArticle> searchContent(String content, Integer page);

    List<bsArticle> getTopArticle();
}
