package com.yuw.producers.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yw.FastDFSClient;
import org.yw.FastDFSResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 10:07
 */
@RestController
public class FastDFSController {

    @RequestMapping("/common/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is first messge!!!";
    }

    @RequestMapping(value = "/common/upload")
    public String upload(){
        FastDFSClient fastDFSClient = new FastDFSClient();
        FastDFSResponse fastDFSResponse = new FastDFSResponse();
        File file = new File("F:\\PIC\\images\\20180605185415_YKhlw.jpeg");
        try {
            fastDFSResponse = fastDFSClient.uploadTo(new FileInputStream(file),"F:\\PIC\\images\\20180605185415_YKhlw.jpeg", new HashMap<>());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(fastDFSResponse);
    }

    @RequestMapping("/common/auth")
    public String foo(String auth) {
        return "hello "+auth+" !!!";
    }
}
