package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.mapper.bsUserFavoritesMapper;
import com.bupt.bsdn.service.bsUserFavoritesService;
import com.bupt.bsdn.entity.bsUserFavorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bsUserFavoritesServiceImpl extends ServiceImpl<bsUserFavoritesMapper, bsUserFavorites> implements bsUserFavoritesService {
    private final bsUserFavoritesMapper bsUserFavoritesMapper;

    @Autowired
    public bsUserFavoritesServiceImpl(bsUserFavoritesMapper bsUserFavoritesMapper) {
        this.bsUserFavoritesMapper = bsUserFavoritesMapper;
    }
}
