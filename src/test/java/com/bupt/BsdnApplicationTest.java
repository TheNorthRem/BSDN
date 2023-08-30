package com.bupt;

import com.bupt.bsdn.BsdnApplication;
import com.bupt.bsdn.config.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BsdnApplication.class)
public class BsdnApplicationTest {


    @Test
    void TestUtils(){
        System.out.println(Utils.getParamSettings("spring.data.redis.expirationTime"));
    }

}
