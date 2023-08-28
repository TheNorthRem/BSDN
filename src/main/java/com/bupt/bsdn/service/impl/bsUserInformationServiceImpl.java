package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsUserInformation;
import com.bupt.bsdn.mapper.bsUserInformationMapper;
import com.bupt.bsdn.service.bsUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bsUserInformationServiceImpl extends ServiceImpl<bsUserInformationMapper, bsUserInformation> implements bsUserInformationService {
    private final bsUserInformationMapper bsUserInformationMapper;

    @Autowired
    public bsUserInformationServiceImpl(bsUserInformationMapper bsUserInformationMapper) {
        this.bsUserInformationMapper = bsUserInformationMapper;
    }
}
