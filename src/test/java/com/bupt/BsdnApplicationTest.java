package com.bupt;

import com.bupt.bsdn.BsdnApplication;
import com.bupt.bsdn.config.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bupt.bsdn.service.bsRedisCacheService;

@SpringBootTest(classes = BsdnApplication.class)
public class BsdnApplicationTest {
    private final bsRedisCacheService bsRedisCacheService;

    @Autowired
    public BsdnApplicationTest(bsRedisCacheService bsRedisCacheService) {
        this.bsRedisCacheService = bsRedisCacheService;
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
}
