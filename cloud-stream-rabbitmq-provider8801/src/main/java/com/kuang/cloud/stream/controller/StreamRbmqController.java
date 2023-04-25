package com.kuang.cloud.stream.controller;

import com.kuang.cloud.stream.service.MessageSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamRbmqController {

    @Resource
    private MessageSendService messageSendService;

    @GetMapping("/sendmessage")
    public String sendMessage() {
        return messageSendService.send();
    }
}
