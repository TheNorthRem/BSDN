package com.bupt.bsdn.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.domain.User;
import com.bupt.bsdn.domain.service.UserService;
import com.bupt.bsdn.domain.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【User】的数据库操作Service实现
* @createDate 2023-08-04 15:51:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




