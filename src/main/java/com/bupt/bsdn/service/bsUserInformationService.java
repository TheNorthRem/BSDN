package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsUserInformation;

import java.util.List;

public interface bsUserInformationService extends IService<bsUserInformation> {
    List<bsUserInformation> search(Integer userId);

}
