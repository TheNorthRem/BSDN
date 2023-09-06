package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUserFavorites;

import java.util.List;

public interface bsUserFavoritesService extends IService<bsUserFavorites> {
    List<bsUserFavorites> getByUserID(Integer userId);
}
