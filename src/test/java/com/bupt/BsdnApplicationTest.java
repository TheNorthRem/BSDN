package com.bupt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.BsdnApplication;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsCommentsService;
import com.bupt.bsdn.service.bsMessageService;
import com.bupt.bsdn.service.bsRedisCacheService;
import com.bupt.bsdn.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bupt.bsdn.mapper.bsCommentsMapper;

@SpringBootTest(classes = BsdnApplication.class)
@Slf4j
public class BsdnApplicationTest {
    private final bsRedisCacheService bsRedisCacheService;
    private final bsMessageService bsMessageService;
    private final bsArticleMapper bsArticleMapper;

    private final bsCommentsService bsCommentsService;

    private final bsCommentsMapper bsCommentsMapper;

    @Autowired
    public BsdnApplicationTest(bsRedisCacheService bsRedisCacheService, bsArticleMapper bsArticleMapper, bsMessageService bsMessageService, bsCommentsService bsCommentsService, bsCommentsMapper bsCommentsMapper) {
        this.bsRedisCacheService = bsRedisCacheService;
        this.bsArticleMapper = bsArticleMapper;
        this.bsMessageService = bsMessageService;
        this.bsCommentsService = bsCommentsService;
        this.bsCommentsMapper = bsCommentsMapper;
    }


    @Test
    void TestUtils() {
        System.out.println(Utils.getParamSettings("expirationTime"));
    }

    @Test
    void TestRedis() {
        bsRedisCacheService.setToken("1", "1");
        bsRedisCacheService.setToken("2", "2");
        bsRedisCacheService.setToken("3", "3");
        bsRedisCacheService.deleteToken("3");
        System.out.println(bsRedisCacheService.getToken("3"));
        //Thread.sleep(5000);
        System.out.println(bsRedisCacheService.getToken("1"));
        //Thread.sleep(6000);
        System.out.println(bsRedisCacheService.getToken("1"));
    }

    @Test
    void TestToken() {
        System.out.println(bsRedisCacheService.makeToken());
        System.out.println(bsRedisCacheService.makeToken());
        System.out.println(bsRedisCacheService.makeToken());
        System.out.println(bsRedisCacheService.makeToken());
    }

    @Test
    void testComment() {
        System.out.println(bsCommentsMapper.getArticleComments(1, new Page<>(1, 4)).getRecords());
    }
}
