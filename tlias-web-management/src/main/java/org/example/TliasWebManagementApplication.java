package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan//开启了SpringBoot对Servlet组件的支持
@SpringBootApplication
@MapperScan("org.example.mapper") //新增这一行！扫描mapper包

public class TliasWebManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(TliasWebManagementApplication.class, args);
    }

}
