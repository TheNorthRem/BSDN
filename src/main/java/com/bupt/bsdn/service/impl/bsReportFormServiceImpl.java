package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsReportForm;
import com.bupt.bsdn.mapper.bsReportFormMapper;
import com.bupt.bsdn.service.bsReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bsReportFormServiceImpl extends ServiceImpl<bsReportFormMapper, bsReportForm> implements bsReportFormService {
    private final bsReportFormMapper bsReportFormMapper;

    @Autowired
    public bsReportFormServiceImpl(bsReportFormMapper bsReportFormMapper) {
        this.bsReportFormMapper = bsReportFormMapper;
    }
}
