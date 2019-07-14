package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct")
public class CommonMqListener {
    private static final Logger log= LoggerFactory.getLogger(CommonMqListener.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    public void process(@Payload byte[] messge){
        try {
            log.info("监听消费用户 监听到消息： {} ","测试队列");
            //TODO：记录日志入数据表
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(messge,User.class);
            System.out.println("Direct 消费消息：" + user.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
