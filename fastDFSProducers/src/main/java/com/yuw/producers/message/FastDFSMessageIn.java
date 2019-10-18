package com.yuw.producers.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/10/10 14:26
 */
@Service
public class FastDFSMessageIn {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage() {
        for (int i = 0; i < 10; i++) {
            // 第一个参数指定队列，第二个参数来指定路由的key，第三个参数指定消息
            amqpTemplate.convertAndSend("fastDFSExchange", "fastDFSKey", "第" + i + "条消息");
        }
    }
}
