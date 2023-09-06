package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.entity.bsUserFavorites;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsArticleService;
import com.bupt.bsdn.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bupt.bsdn.service.bsUserService;

import java.util.ArrayList;
import java.util.List;
import com.bupt.bsdn.service.bsUserFavoritesService;
@Service
public class bsArticleServiceImpl extends ServiceImpl<bsArticleMapper, bsArticle> implements bsArticleService {
    private final bsArticleMapper bsArticleMapper;
    private final bsUserService bsUserService;

    private final bsUserFavoritesService bsUserFavoritesService;
    @Autowired
    public bsArticleServiceImpl(bsArticleMapper bsArticleMapper , bsUserService bsUserService,bsUserFavoritesService bsUserFavoritesService) {
        this.bsArticleMapper = bsArticleMapper;
        this.bsUserService= bsUserService;
        this.bsUserFavoritesService=bsUserFavoritesService;
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

    @Override
    public List<bsArticle> getArticlesByUserId(Integer userId) {
        return bsArticleMapper.searchByUser(userId);
    }

    @Override
    public List<bsArticle> getFavoriteArticles(Integer userId) {
        QueryWrapper<bsUserFavorites> queryWrapper=new QueryWrapper<>();
        queryWrapper.ge("userId",userId);
        System.out.println(userId);
        List<bsUserFavorites> favoriteArticles = bsUserFavoritesService.getByUserID(userId);
        List<bsArticle> list=new ArrayList<>();
        for(bsUserFavorites f :favoriteArticles){
            Integer articleId = f.getArticleId();
            list.add(bsArticleMapper.getById(articleId));
        }
        return list;
    }
}
