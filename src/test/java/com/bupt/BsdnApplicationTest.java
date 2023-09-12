package com.bupt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.BsdnApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bupt.bsdn.mapper.bsArticleMapper;

@SpringBootTest(classes = BsdnApplication.class)
@Slf4j
public class BsdnApplicationTest {

    private final bsArticleMapper bsArticleMapper;

    @Autowired
    public BsdnApplicationTest(bsArticleMapper bsArticleMapper) {
        this.bsArticleMapper = bsArticleMapper;
    }
    @Test
    void test() {
        System.out.println(bsArticleMapper.searchContent("C++", new Page<>(1, 5)).getRecords());
    }
}
