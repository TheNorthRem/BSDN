package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.Message;
import com.bupt.bsdn.service.MessageService;
import com.bupt.bsdn.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【Message】的数据库操作Service实现
* @createDate 2023-08-04 16:23:52
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




