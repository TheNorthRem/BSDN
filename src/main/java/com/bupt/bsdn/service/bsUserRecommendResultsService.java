package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUserRecommendResults;

import java.util.List;

public interface bsUserRecommendResultsService extends IService<bsUserRecommendResults> {
    List<bsUserRecommendResults> recommendList(Integer userId);
}
