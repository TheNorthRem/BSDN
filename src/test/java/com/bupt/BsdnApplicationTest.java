package com.bupt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.BsdnApplication;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsRedisCacheService;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BsdnApplication.class)
@Slf4j
public class BsdnApplicationTest {
    private final bsRedisCacheService bsRedisCacheService;

    private final bsArticleMapper bsArticleMapper;

    @Autowired
    public BsdnApplicationTest(bsRedisCacheService bsRedisCacheService, bsArticleMapper bsArticleMapper) {
        this.bsRedisCacheService = bsRedisCacheService;
        this.bsArticleMapper = bsArticleMapper;
    }


    @Test
    void TestUtils() {
        System.out.println(Utils.getParamSettings("expirationTime"));
    }

    @Test
    void TestRedis() throws InterruptedException {
        bsRedisCacheService.setToken("1", "1");
        bsRedisCacheService.setToken("2", "2");
        bsRedisCacheService.setToken("3", "3");
        bsRedisCacheService.deleteToken("3");
        System.out.println(bsRedisCacheService.getToken("3"));
        Thread.sleep(5000);
        System.out.println(bsRedisCacheService.getToken("1"));
        Thread.sleep(6000);
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
    void TestArticle() {
        bsArticle article = new bsArticle();
        System.out.println(article.getUploadTime());
    }

    @Test
    void TestImage() {

    }

    @Test
    void TestPage() {
        Page<bsArticle> page = new Page<>(1, 2);
        Page<bsArticle> bsArticlePage = bsArticleMapper.selectPage(page, null);
        System.out.println(Result.ok(bsArticlePage));
    }
}
