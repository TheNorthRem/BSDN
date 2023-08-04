package com.bupt.bsdn.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.domain.Message;
import com.bupt.bsdn.domain.service.MessageService;
import com.bupt.bsdn.domain.mapper.MessageMapper;
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




