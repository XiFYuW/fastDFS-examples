package com.yuw.producers.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author https://github.com/XiFYuW
 * @date 2019/10/10 14:26
 */
@Component
public class FastDFSMessageOut {
    private Logger logger =  LoggerFactory.getLogger(FastDFSMessageOut.class);

    @RabbitListener(bindings = @QueueBinding(value = @Queue("fastDFSQueue"), exchange = @Exchange("fastDFSExchange"), key = "fastDFSKey"))
    public void processFastDFS(String message) {
        logger.info("fastDFS message : {}", message);
    }
}
