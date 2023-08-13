package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.User;
import com.bupt.bsdn.service.UserService;
import com.bupt.bsdn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【User】的数据库操作Service实现
* @createDate 2023-08-04 15:51:58
*/
@Service
@Order(4)
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    UserMapper mapper;
    @Override
    public void RegisterUser(User user) {
        if(user.getUserId()==null)
            mapper.insert(user);
    }
}




