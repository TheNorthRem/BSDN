package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsMessage;
import com.bupt.bsdn.mapper.bsMessageMapper;
import com.bupt.bsdn.service.bsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bsMessageServiceImpl extends ServiceImpl<bsMessageMapper, bsMessage> implements bsMessageService {
    private final bsMessageMapper bsMessageMapper;

    @Autowired
    public bsMessageServiceImpl(bsMessageMapper bsMessageMapper) {
        this.bsMessageMapper = bsMessageMapper;
    }
}
