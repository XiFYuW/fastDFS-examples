package com.yuw.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/23 10:21
 */
@SpringBootApplication
@EnableZuulProxy
public class FastDFSZuulApplication {

    public static void main(String[] args){
        SpringApplication.run(FastDFSZuulApplication.class, args);
    }
}
