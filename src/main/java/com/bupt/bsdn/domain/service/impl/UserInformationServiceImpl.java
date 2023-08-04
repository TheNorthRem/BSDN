package com.bupt.bsdn.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.domain.UserInformation;
import com.bupt.bsdn.domain.service.UserInformationService;
import com.bupt.bsdn.domain.mapper.UserInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author liyehui
* @description 针对表【User_Information】的数据库操作Service实现
* @createDate 2023-08-04 16:22:58
*/
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserInformation>
    implements UserInformationService{

}




