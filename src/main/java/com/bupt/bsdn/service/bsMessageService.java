package com.bupt.bsdn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bupt.bsdn.entity.bsMessage;

import java.util.List;
import com.bupt.bsdn.entity.bsUser;

public interface bsMessageService extends IService<bsMessage> {
    List<bsUser> searchSendUser(Integer userId);

    List<bsMessage> searchMessage(Integer userFromId, Integer userToId);
}
