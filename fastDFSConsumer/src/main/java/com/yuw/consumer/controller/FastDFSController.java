package com.yuw.consumer.controller;

import com.yuw.consumer.service.FastDFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/9/21 10:07
 */
@RestController
public class FastDFSController {

    @Resource
    FastDFSService fastDFSService;

    @RequestMapping("/common/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return fastDFSService.hello(name);
    }

    @RequestMapping(value = "/common/upload")
    public String index() {
        return fastDFSService.upload();
    }
}
