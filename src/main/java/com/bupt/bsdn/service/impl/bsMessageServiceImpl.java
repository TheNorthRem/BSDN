package com.bupt.bsdn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.bsMessage;
import com.bupt.bsdn.entity.bsUser;
import com.bupt.bsdn.mapper.bsMessageMapper;
import com.bupt.bsdn.service.bsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class bsMessageServiceImpl extends ServiceImpl<bsMessageMapper, bsMessage> implements bsMessageService {
    private final bsMessageMapper bsMessageMapper;

    @Autowired
    public bsMessageServiceImpl(bsMessageMapper bsMessageMapper) {
        this.bsMessageMapper = bsMessageMapper;
    }

    @Override
    public List<bsUser> searchSendUser(Integer userId) {
        List<bsUser> bsUsers = bsMessageMapper.searchSendUser(userId);
        bsUsers.addAll(bsMessageMapper.searchReceiveUser(userId));
        HashSet<bsUser> Set=new HashSet<>(bsUsers);
        bsUsers.clear();
        bsUsers.addAll(Set);
        return bsUsers;
    }

    @Override
    public List<bsMessage> searchMessage(Integer userFromId, Integer userToId) {
        return bsMessageMapper.searchMessage(userFromId, userToId);
    }
}
