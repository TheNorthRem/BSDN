package com.bupt.bsdn;

import com.bupt.bsdn.entity.User;
import com.bupt.bsdn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BsdnApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    UserService userService;
    @Test
    void UserMapperTest(){


        User user=new User();
        user.setUserName("2021211415");
        user.setIsadmin(1);
        user.setNickname("Yeti");
        user.setPassword("137100");
        userService.RegisterUser(user);
        System.out.println(user.getUserId());
    }
}
