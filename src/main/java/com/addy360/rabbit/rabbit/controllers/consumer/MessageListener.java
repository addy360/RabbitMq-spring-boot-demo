package com.addy360.rabbit.rabbit.controllers.consumer;

import com.addy360.rabbit.rabbit.configs.MQConfig;
import com.addy360.rabbit.rabbit.messages.CustomeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MessageListener {

    @RabbitListener(queues = MQConfig.messageQueue)
    public void listener(CustomeMessage customeMessage){
        log.info("Received data from rabbitMQ is : {}",customeMessage.toString());
    }
}
