package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsFavorites;
import com.bupt.bsdn.entity.bsUser;

import java.util.List;

public interface bsFavoritesService extends IService<bsFavorites> {
    List<bsUser> followers(Integer id);

    List<bsUser> following(Integer id);
}
