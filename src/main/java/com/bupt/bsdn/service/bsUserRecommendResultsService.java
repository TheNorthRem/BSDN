package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUserRecommendResults;

public interface bsUserRecommendResultsService extends IService<bsUserRecommendResults> {
    String recommendList(Integer userId);
}
