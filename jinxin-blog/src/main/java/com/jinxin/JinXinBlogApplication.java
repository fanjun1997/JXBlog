package com.jinxin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 86188
 * @version 1.0
 * @description 今心Blog
 * @data 2023/4/18 20:49
 */
@SpringBootApplication
@MapperScan("com.jinxin.mapper")
public class JinXinBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(JinXinBlogApplication.class, args);
    }

}
