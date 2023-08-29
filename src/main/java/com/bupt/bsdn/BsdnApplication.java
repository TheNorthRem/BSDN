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
        String message = """
                ////////////////////////////////////////////////////////////////////
                //                          _ooOoo_                               //
                //                         o8888888o                              //
                //                         88" . "88                              //
                //                         (| ^_^ |)                              //
                //                         O\\  =  /O                              //
                //                      ____/`---'\\____                           //
                //                    .'  \\\\|     |//  `.                         //
                //                   /  \\\\|||  :  |||//  \\                        //
                //                  /  _||||| -:- |||||-  \\                       //
                //                  |   | \\\\\\  -  /// |   |                       //
                //                  | \\_|  ''\\---/''  |   |                       //
                //                  \\  .-\\__  `-`  ___/-. /                       //
                //                ___`. .'  /--.--\\  `. . ___                     //
                //              ."" '<  `.___\\_<|>_/___.'  >'"".                  //
                //            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //
                //            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //
                //      ========`-.____`-.___\\_____/___.-`____.-'========         //
                //                           `=---='                              //
                //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
                //             佛祖保佑       永不宕机      永无BUG                   //
                ////////////////////////////////////////////////////////////////////""";
        System.out.println(message);
        SpringApplication.run(BsdnApplication.class, args);
    }
}
