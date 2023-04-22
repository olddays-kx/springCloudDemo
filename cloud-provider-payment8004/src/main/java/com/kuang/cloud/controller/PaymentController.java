package com.kuang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @GetMapping(value = "/payment/zk")
    public String getZkMessage() {
        return "springcloud with zookeeper: "+SERVER_PORT+"\t"+ UUID.randomUUID().toString();
    }
}
