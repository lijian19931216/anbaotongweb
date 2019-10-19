package com.anbaotong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.anbaotong.mapper") //扫描的mapper
@SpringBootApplication
@EnableAspectJAutoProxy
public class AnbaotongApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AnbaotongApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AnbaotongApplication.class);
    }

}
