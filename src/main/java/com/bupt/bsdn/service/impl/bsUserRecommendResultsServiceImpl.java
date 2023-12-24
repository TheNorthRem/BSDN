package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsUserRecommendResults;
import com.bupt.bsdn.mapper.bsUserRecommendResultsMapper;
import com.bupt.bsdn.service.bsUserRecommendResultsService;
import org.springframework.stereotype.Service;

@Service
public class bsUserRecommendResultsServiceImpl extends ServiceImpl<bsUserRecommendResultsMapper, bsUserRecommendResults> implements bsUserRecommendResultsService {
    @Override
    public String recommendList(Integer userId) {
        QueryWrapper<bsUserRecommendResults> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.getOne(queryWrapper).getRecommendResults();
    }
}
