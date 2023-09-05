package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUser;

import java.util.List;

public interface bsUserService extends IService<bsUser> {
    /**
     *
     * 通过用户名获取用户对象
     *
     */

    bsUser getUserByUsername(String username);

    List<bsUser> search(String userName);


}
