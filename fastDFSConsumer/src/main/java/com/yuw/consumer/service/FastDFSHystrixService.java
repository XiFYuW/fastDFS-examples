package com.yuw.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 10:07
 */
@Component
public class FastDFSHystrixService implements FastDFSService{

    @RequestMapping(value = "/common/hello")
    public String hello(@RequestParam(value = "name") String name){
        return "hello" +name+", this messge send failed ";
    }

    @RequestMapping(value = "/common/upload")
    public String upload(){
        return "fastDFS文件服务异常";
    }
}
