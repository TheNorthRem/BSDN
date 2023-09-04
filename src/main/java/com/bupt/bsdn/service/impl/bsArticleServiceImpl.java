package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsArticleService;
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
    public List<bsArticle> searchContent(String content) {
        return bsArticleMapper.searchContent(content);
    }
}
