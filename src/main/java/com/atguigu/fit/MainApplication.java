package com.atguigu.fit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 申明这是一个Springboot应用
 * controller类应该放在boot包下或者子包下否则将访问不到
 */
@MapperScan("com.atguigu.fit.mapper")
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
