package com.bupt.bsdn.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bsdn.entity.ArchiveBook;
import com.bupt.bsdn.mapper.ArchiveBookMapper;
import com.bupt.bsdn.service.ArchiveBookService;
import org.springframework.stereotype.Service;

@Service
public class ArchiveBookServiceImpl extends ServiceImpl<ArchiveBookMapper, ArchiveBook> implements ArchiveBookService {
}
