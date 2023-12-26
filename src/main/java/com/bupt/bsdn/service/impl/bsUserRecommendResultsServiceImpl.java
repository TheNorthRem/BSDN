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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class bsUserRecommendResultsServiceImpl extends ServiceImpl<bsUserRecommendResultsMapper, bsUserRecommendResults> implements bsUserRecommendResultsService {
    private final bsArticleService bsArticleService;

    private final ArchiveBookService archiveBookService;

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
}
