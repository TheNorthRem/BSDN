package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsHistory;
import com.bupt.bsdn.mapper.bsHistoryMapper;
import com.bupt.bsdn.service.bsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bsHistoryServiceImpl extends ServiceImpl<bsHistoryMapper, bsHistory> implements bsHistoryService {
    private final bsHistoryMapper bsHistoryMapper;

    @Autowired
    public bsHistoryServiceImpl(bsHistoryMapper bsHistoryMapper) {
        this.bsHistoryMapper = bsHistoryMapper;
    }
}
