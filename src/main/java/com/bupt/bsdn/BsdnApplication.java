package com.bupt.bsdn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bupt.bsdn.mapper")
public class BsdnApplication {
    public static void main(String[] args) {
        SpringApplication.run(BsdnApplication.class, args);
    }

}
