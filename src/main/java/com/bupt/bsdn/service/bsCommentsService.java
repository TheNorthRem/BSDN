package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsComments;
import java.util.List;
public interface bsCommentsService extends IService<bsComments> {
    public List<bsComments> getCommentsByArticle(Integer articleId);

    public Page<bsComments> getCommentsByFatherId(Integer fatherId,Integer pages);


}
