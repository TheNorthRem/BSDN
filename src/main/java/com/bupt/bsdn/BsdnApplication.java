package com.bupt.bsdn;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bupt.bsdn.mapper")
@Slf4j
public class BsdnApplication {
    public static void main(String[] args) {
        SpringApplication.run(BsdnApplication.class, args);
    }

}
