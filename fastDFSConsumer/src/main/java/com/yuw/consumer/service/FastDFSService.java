package com.yuw.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 10:07
 */
@FeignClient(name= "fastDFSProducer",fallback = FastDFSHystrixService.class)
public interface FastDFSService {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/upload")
    String upload();
}
