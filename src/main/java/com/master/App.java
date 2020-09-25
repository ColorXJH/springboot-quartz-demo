package com.master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/24 20:45
 */
@SpringBootApplication
//@MapperScan("com.master.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
