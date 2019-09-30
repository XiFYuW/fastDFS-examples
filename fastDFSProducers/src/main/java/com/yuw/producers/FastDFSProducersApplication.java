package com.yuw.producers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 10:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FastDFSProducersApplication {

    public static void main(String[] args){
        SpringApplication.run(FastDFSProducersApplication.class);
    }
}
