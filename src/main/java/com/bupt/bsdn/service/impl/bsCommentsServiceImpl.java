package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsComments;
import com.bupt.bsdn.mapper.bsCommentsMapper;
import com.bupt.bsdn.service.bsCommentsService;
import com.bupt.bsdn.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bsCommentsServiceImpl extends ServiceImpl<bsCommentsMapper, bsComments> implements bsCommentsService {
    private final bsCommentsMapper bsCommentsMapper;

    @Autowired
    public bsCommentsServiceImpl(bsCommentsMapper bsCommentsMapper) {
        this.bsCommentsMapper = bsCommentsMapper;
    }

    @Override
    public Page<bsComments> getCommentsByFatherId(Integer fatherId, Integer pages) {
        Page<bsComments> page = new Page<>(pages, Long.parseLong(Utils.getParamSettings("PageSize")));
        QueryWrapper<bsComments> wrapper = new QueryWrapper<>();
        wrapper.ge("fatherCommentId", fatherId);
        return bsCommentsMapper.selectPage(page, wrapper);
    }

    @Override
    public Page<bsComments> getArticleComments(Integer articleId, Integer pages) {
        Page<bsComments> page = new Page<>(pages, Long.parseLong(Utils.getParamSettings("PageSize")));
        return bsCommentsMapper.getArticleComments(articleId, page);
    }
}
