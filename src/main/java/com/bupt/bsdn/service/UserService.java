package com.bupt.bsdn.service;

import com.bupt.bsdn.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liyehui
* @description 针对表【User】的数据库操作Service
* @createDate 2023-08-04 15:51:58
*/
public interface UserService extends IService<User> {
    public void RegisterUser(User user);
}
