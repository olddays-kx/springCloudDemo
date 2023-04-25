package com.kuang.cloud.stream.service.impl;

import com.kuang.cloud.stream.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageSendServiceImpl implements MessageSendService {

    @Qualifier("output")
    @Autowired
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        this.messageChannel.send(MessageBuilder.withPayload(message).build());

        System.out.println(".......message: " + message);
        return message;
    }
}
