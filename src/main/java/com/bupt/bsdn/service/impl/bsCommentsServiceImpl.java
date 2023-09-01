package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsComments;
import com.bupt.bsdn.mapper.bsCommentsMapper;
import com.bupt.bsdn.service.bsCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bsCommentsServiceImpl extends ServiceImpl<bsCommentsMapper, bsComments> implements bsCommentsService {
    private final bsCommentsMapper bsCommentsMapper;

    @Autowired
    public bsCommentsServiceImpl(bsCommentsMapper bsCommentsMapper) {
        this.bsCommentsMapper = bsCommentsMapper;
    }

    @Override
    public List<bsComments> getCommentsByArticle(Integer articleId) {
        return bsCommentsMapper.getFatherCommentsByArticle(articleId);
    }

    @Override
    public List<bsComments> getCommentsByFatherId(Integer fatherArticleId) {
        return bsCommentsMapper.getSonCommentsById(fatherArticleId);
    }
}
