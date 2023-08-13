package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.Article;
import com.bupt.bsdn.service.ArticleService;
import com.bupt.bsdn.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【Article】的数据库操作Service实现
* @createDate 2023-08-04 15:54:53
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

}




