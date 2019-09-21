package com.yuw.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 9:25
 */
@SpringBootApplication
@EnableEurekaServer
public class FastDFSEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastDFSEurekaApplication.class, args);
    }
}
