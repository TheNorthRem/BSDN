package com.bupt;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bupt.bsdn.BsdnApplication;
import com.bupt.bsdn.entity.bsArticle;
import com.bupt.bsdn.entity.bsMessage;
import com.bupt.bsdn.mapper.bsArticleMapper;
import com.bupt.bsdn.service.bsRedisCacheService;
import com.bupt.bsdn.util.Result;
import com.bupt.bsdn.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bupt.bsdn.service.bsMessageService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BsdnApplication.class)
@Slf4j
public class BsdnApplicationTest {
    private final bsRedisCacheService bsRedisCacheService;
    private final bsMessageService bsMessageService;
    private final bsArticleMapper bsArticleMapper;

    @Autowired
    public BsdnApplicationTest(bsRedisCacheService bsRedisCacheService, bsArticleMapper bsArticleMapper,bsMessageService bsMessageService) {
        this.bsRedisCacheService = bsRedisCacheService;
        this.bsArticleMapper = bsArticleMapper;
        this.bsMessageService=bsMessageService;
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

    @Test
    void TestSelect(){
        List<bsMessage> messages =new ArrayList<>();
        Integer userFromId=1;
        Integer userToId=2;
        messages.addAll(bsMessageService.searchMessage(userFromId, userToId));
        messages.addAll(bsMessageService.searchMessage(userToId, userFromId));
        messages.sort((m1,m2)->((m2.getTime().compareTo(m1.getTime()))));
        for(bsMessage m:messages){
            System.out.println(m);
        }
    }
}
