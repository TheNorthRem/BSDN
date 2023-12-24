package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.service.bsUserRecommendResultsService;
import com.bupt.bsdn.mapper.bsUserRecommendResultsMapper;
import com.bupt.bsdn.entity.bsUserRecommendResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bsUserRecommendResultsServiceImpl extends ServiceImpl<bsUserRecommendResultsMapper, bsUserRecommendResults> implements bsUserRecommendResultsService {
    @Override
    public List<bsUserRecommendResults> recommendList(Integer userId) {
        QueryWrapper<bsUserRecommendResults> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }
}
