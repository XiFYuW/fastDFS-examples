package com.yuw.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/24 11:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class FastDFSZipkinApplication {

    public static void main(String[] args){
        SpringApplication.run(FastDFSZipkinApplication.class, args);
    }
}
