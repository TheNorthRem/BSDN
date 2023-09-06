package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsArticleService;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bupt.bsdn.service.bsUserService;
import java.util.List;

@Service
public class bsArticleServiceImpl extends ServiceImpl<bsArticleMapper, bsArticle> implements bsArticleService {
    private final bsArticleMapper bsArticleMapper;
    private final bsUserService bsUserService;
    @Autowired
    public bsArticleServiceImpl(bsArticleMapper bsArticleMapper , bsUserService bsUserService) {
        this.bsArticleMapper = bsArticleMapper;
        this.bsUserService= bsUserService;
    }

    @Override
    public Page<bsArticle> search(String content, Integer page) {
        Page<bsArticle> bsArticlePage = new Page<>(page, Long.parseLong(Utils.getParamSettings("PageSize")));
        return bsArticleMapper.search(content, bsArticlePage);


    }

    @Override
    public Page<bsArticle> searchContent(String content, Integer page) {
        Page<bsArticle> bsArticlePage = new Page<>(page, Long.parseLong(Utils.getParamSettings("PageSize")));
        return bsArticleMapper.searchContent(content, bsArticlePage);
    }


    @Override
    public Page<bsArticle> searchByCategory(String category, Integer page) {
        Page<bsArticle> bsArticlePage = new Page<>(page, Long.parseLong(Utils.getParamSettings("PageSize")));
        return bsArticleMapper.searchByCategory(category,bsArticlePage);
    }


    @Override
    public List<bsArticle> getTopArticle() {
        List<bsArticle> topContent = bsArticleMapper.getTopContent();

        for(bsArticle article:topContent){
            bsUser byId = bsUserService.getById(article.getUploaderId());
            article.setNickName(byId.getNickName());
            byId.setAvatar(byId.getAvatar());

        }

        return topContent;
    }
}
