package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsFavorites;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.mapper.bsFavoritesMapper;
import com.bupt.bsdn.service.bsFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bsFavoritesServiceImpl extends ServiceImpl<bsFavoritesMapper, bsFavorites> implements bsFavoritesService {
    private final bsFavoritesMapper bsFavoritesMapper;

    @Autowired
    public bsFavoritesServiceImpl(bsFavoritesMapper bsFavoritesMapper) {
        this.bsFavoritesMapper = bsFavoritesMapper;
    }

    @Override
    public List<bsUser> followers(Integer id) {
        return bsFavoritesMapper.followers(id);
    }

    @Override
    public List<bsUser> following(Integer id) {
        return bsFavoritesMapper.following(id);
    }
}
