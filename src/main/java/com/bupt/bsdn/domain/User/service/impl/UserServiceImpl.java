package com.bupt.bsdn.domain.User.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.domain.User.User;
import com.bupt.bsdn.domain.User.service.UserService;
import com.bupt.bsdn.domain.User.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【User】的数据库操作Service实现
* @createDate 2023-08-03 14:52:23
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




