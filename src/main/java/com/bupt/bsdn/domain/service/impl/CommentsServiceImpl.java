package com.bupt.bsdn.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.domain.Comments;
import com.bupt.bsdn.domain.service.CommentsService;
import com.bupt.bsdn.domain.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【Comments】的数据库操作Service实现
* @createDate 2023-08-04 16:24:10
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

}




