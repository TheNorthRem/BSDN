package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsArticle;

import java.util.List;

public interface bsArticleService extends IService<bsArticle> {
    List<bsArticle> search(String content);

    List<bsArticle> searchContent(String content);

    List<bsArticle> getTopArticle();
}
