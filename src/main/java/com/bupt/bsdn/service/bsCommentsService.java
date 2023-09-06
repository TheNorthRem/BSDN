package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsComments;

public interface bsCommentsService extends IService<bsComments> {
    Page<bsComments> getCommentsByFatherId(Integer fatherId, Integer pages);

    Page<bsComments> getArticleComments(Integer articleId, Integer pages);
}
