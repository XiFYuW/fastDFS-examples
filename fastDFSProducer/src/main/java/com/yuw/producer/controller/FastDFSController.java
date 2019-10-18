package com.yuw.producer.controller;

import com.alibaba.fastjson.JSON;
import com.yuw.producer.message.FastDFSMessageIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yw.FastDFSResponse;
import org.yw.interfaces.FastDFSDefault;

import java.io.File;
import java.util.HashMap;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 10:07
 */
@RestController
@RefreshScope
public class FastDFSController {

    @Value("${auth}")
    private String auth;

    @Autowired
    private FastDFSMessageIn fastDFSMessageIn;

    @Autowired
    private FastDFSDefault fastDFSDefault;

    @RequestMapping("/common/hello")
    public String index(@RequestParam String name) {
        fastDFSMessageIn.sendMessage();
        return "hello "+name+"，this is first messge，auth " + auth;
    }

    @RequestMapping(value = "/common/upload")
    public String upload(){
        File file = new File("F:\\PIC\\images\\20180605185415_YKhlw.jpeg");
        FastDFSResponse fastDFSResponse = fastDFSDefault.upload(file,"F:\\PIC\\images\\20180605185415_YKhlw.jpeg", new HashMap<>());
        return JSON.toJSONString(fastDFSResponse);
    }

    @RequestMapping(value = "/common/download")
    public String download(@RequestParam String fp){
        FastDFSResponse fastDFSResponse = fastDFSDefault.download(fp,"C:\\Users\\Shinelon\\Desktop\\");
        return JSON.toJSONString(fastDFSResponse);
    }

    @RequestMapping(value = "/common/delete")
    public String delete(@RequestParam String fp){
        FastDFSResponse fastDFSResponse = fastDFSDefault.delete(fp);
        return JSON.toJSONString(fastDFSResponse);
    }

    @RequestMapping("/common/auth")
    public String foo(String auth) {
        return "hello "+auth+"!";
    }
}
