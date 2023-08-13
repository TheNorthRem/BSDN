package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.UserInformation;
import com.bupt.bsdn.service.UserInformationService;
import com.bupt.bsdn.mapper.UserInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【User_Information】的数据库操作Service实现
* @createDate 2023-08-04 16:22:58
*/
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserInformation>
    implements UserInformationService {

}




