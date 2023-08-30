package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.mapper.bsUserMapper;
import com.bupt.bsdn.service.bsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bsUserServiceImpl extends ServiceImpl<bsUserMapper, bsUser> implements bsUserService {
    private final bsUserMapper bsUserMapper;

    @Autowired
    public bsUserServiceImpl(bsUserMapper bsUserMapper) {
        this.bsUserMapper = bsUserMapper;
    }

    @Override
    public bsUser getUserByUsername(String username) {
        return bsUserMapper.getUserByUsername(username);
    }
}
