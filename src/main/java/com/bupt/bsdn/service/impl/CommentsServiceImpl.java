package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.Comments;
import com.bupt.bsdn.service.CommentsService;
import com.bupt.bsdn.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【Comments】的数据库操作Service实现
* @createDate 2023-08-04 16:24:10
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService {

}




