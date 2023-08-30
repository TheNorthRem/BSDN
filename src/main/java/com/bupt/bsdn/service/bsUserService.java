package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUser;

import java.util.List;

public interface bsUserService extends IService<bsUser> {
    List<bsUser> selectFive();
    bsUser getUserByUsername(String username);
}
