package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsArticleService;
import com.bupt.bsdn.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bsArticleServiceImpl extends ServiceImpl<bsArticleMapper, bsArticle> implements bsArticleService {
    private final bsArticleMapper bsArticleMapper;

    @Autowired
    public bsArticleServiceImpl(bsArticleMapper bsArticleMapper) {
        this.bsArticleMapper = bsArticleMapper;
    }

    @Override
    public List<bsArticle> search(String content) {

        return bsArticleMapper.search(content);


    }

    @Override
    public Page<bsArticle> searchContent(String content, Integer page) {
        Page<bsArticle> bsArticlePage = new Page<>(page, Long.parseLong(Utils.getParamSettings("PageSize")));
        return bsArticleMapper.searchContent(content, bsArticlePage);
    }

    @Override
    public List<bsArticle> getTopArticle() {
        return bsArticleMapper.getTopContent();
    }
}
