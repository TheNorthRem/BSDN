package com.bupt.bsdn.service.impl;


import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.ArchiveBook;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.entity.bsUserRecommendResults;
import com.bupt.bsdn.mapper.bsUserRecommendResultsMapper;
import com.bupt.bsdn.service.ArchiveBookService;
import com.bupt.bsdn.service.bsArticleService;
import com.bupt.bsdn.service.bsUserRecommendResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class bsUserRecommendResultsServiceImpl extends ServiceImpl<bsUserRecommendResultsMapper, bsUserRecommendResults> implements bsUserRecommendResultsService {
    private final bsArticleService bsArticleService;

    private final ArchiveBookService archiveBookService;

    private static final Map<String, Integer> category;


    static {
        category = new HashMap<>();
        category.put("前端", 0);
        category.put("后端", 1);
        category.put("数据库", 2);
        category.put("生活", 3);
        category.put("编程语言", 4);
    }

    @Autowired
    public bsUserRecommendResultsServiceImpl(bsArticleService bsArticleService, ArchiveBookService archiveBookService) {
        this.bsArticleService = bsArticleService;
        this.archiveBookService = archiveBookService;
    }

    @Override
    public List<JSONObject> recommendList(Integer userId) {
        QueryWrapper<bsUserRecommendResults> bsUserRecommendResultsQueryWrapper = new QueryWrapper<>();
        bsUserRecommendResultsQueryWrapper.eq("user_id", userId);

        bsUserRecommendResults bsUserRecommendResults = this.getOne(bsUserRecommendResultsQueryWrapper);
        if (bsUserRecommendResults == null) {
            return Collections.emptyList();
        }

        List<String> recommends = List.of(bsUserRecommendResults.getRecommendResults().split("-"));
        ArrayList<JSONObject> ans = new ArrayList<>();
        for (String recommend : recommends) {
            QueryWrapper<ArchiveBook> archiveBookQueryWrapper = new QueryWrapper<>();
            archiveBookQueryWrapper.eq("ISBN", recommend);
            ArchiveBook archiveBook = archiveBookService.getOne(archiveBookQueryWrapper);

            QueryWrapper<bsArticle> bsArticleQueryWrapper = new QueryWrapper<>();
            bsArticleQueryWrapper.eq("article_id", recommend);
            bsArticle bsArticle = bsArticleService.getOne(bsArticleQueryWrapper);

            if (archiveBook == null || bsArticle == null) {
                continue;
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("archiveBook", archiveBook);
            jsonObject.put("bsArticle", bsArticle);
            ans.add(jsonObject);
        }
        return ans;
    }

    @Override
    public List<JSONObject> recommendVisualization(Integer userId) {
        QueryWrapper<bsUserRecommendResults> bsUserRecommendResultsQueryWrapper = new QueryWrapper<>();
        bsUserRecommendResultsQueryWrapper.eq("user_id", userId);

        bsUserRecommendResults bsUserRecommendResults = this.getOne(bsUserRecommendResultsQueryWrapper);
        if (bsUserRecommendResults == null) {
            return Collections.emptyList();
        }

        List<String> recommends = List.of(bsUserRecommendResults.getRecommendResults().split("-"));
        ArrayList<bsArticle> bsArticles = new ArrayList<>();
        for (String recommend : recommends) {
            QueryWrapper<bsArticle> bsArticleQueryWrapper = new QueryWrapper<>();
            bsArticleQueryWrapper.eq("article_id", recommend);
            bsArticle bsArticle = bsArticleService.getOne(bsArticleQueryWrapper);

            if (bsArticle == null) {
                continue;
            }
            bsArticles.add(bsArticle);
        }

        int[] categoryCount = new int[category.size()];
        int[] categoryClickCount = new int[category.size()];
        for (bsArticle bsArticle : bsArticles) {
            categoryCount[category.get(bsArticle.getCategory())]++;
            categoryClickCount[category.get(bsArticle.getCategory())] += bsArticle.getClickCount();
        }

        ArrayList<JSONObject> ans = new ArrayList<>();
        for (String cate : category.keySet()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("category", cate);
            jsonObject.put("article_count", categoryCount[category.get(cate)]);
            jsonObject.put("clickCount", categoryClickCount[category.get(cate)]);
            ans.add(jsonObject);
        }
        return ans;
    }
}
