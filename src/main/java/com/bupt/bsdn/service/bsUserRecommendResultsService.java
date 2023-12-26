package com.bupt.bsdn.service;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUserRecommendResults;

import java.util.List;

public interface bsUserRecommendResultsService extends IService<bsUserRecommendResults> {
    List<JSONObject> recommendList(Integer userId);

    List<JSONObject> recommendVisualization(Integer userId);
}
