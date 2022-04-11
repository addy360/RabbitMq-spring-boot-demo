package com.addy360.rabbit.rabbit.controllers.publisher;

import com.addy360.rabbit.rabbit.configs.MQConfig;
import com.addy360.rabbit.rabbit.messages.CustomeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/publish")
@Slf4j
public class MessageController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public String publishMessage(@RequestBody CustomeMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date().toString());
        log.info("Request body is to send to MQ : {}", message.toString());
        this.template.convertAndSend( MQConfig.messageTopicExchange,MQConfig.messageRoutingKey, message);
        return "Message received and published";
    }
}
