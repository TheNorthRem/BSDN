package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.entity.bsUserRecommendResults;
import com.bupt.bsdn.mapper.bsUserRecommendResultsMapper;
import com.bupt.bsdn.service.bsUserRecommendResultsService;
import com.bupt.bsdn.service.bsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class bsUserRecommendResultsServiceImpl extends ServiceImpl<bsUserRecommendResultsMapper, bsUserRecommendResults> implements bsUserRecommendResultsService {
    private final bsArticleService bsArticleService;

    @Autowired
    public bsUserRecommendResultsServiceImpl(bsArticleService bsArticleService) {
        this.bsArticleService = bsArticleService;
    }

    @Override
    public List<bsArticle> recommendList(Integer userId) {
        QueryWrapper<bsUserRecommendResults> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        bsUserRecommendResults v = this.getOne(queryWrapper);
        if (v == null) {
            return Collections.emptyList();
        }
        String recommends = v.getRecommendResults();
        List<String> recommendList = Arrays.stream(recommends.split("-")).toList();
        ArrayList<bsArticle> bsArticles = new ArrayList<>();
        for (var recommend : recommendList) {
            QueryWrapper<bsArticle> bsArticleQueryWrapper = new QueryWrapper<>();
            bsArticleQueryWrapper.eq("article_id", recommend);
            bsArticle bsArticle = bsArticleService.getOne(bsArticleQueryWrapper);
            if (bsArticle != null) {
                bsArticles.add(bsArticle);
            }
        }
        return bsArticles;
    }
}
