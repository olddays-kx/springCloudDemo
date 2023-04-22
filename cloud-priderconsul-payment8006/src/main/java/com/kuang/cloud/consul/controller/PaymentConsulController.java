package com.kuang.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul/get")
    public String paymentConsul() {
        return "springcloud with consul: "+serverPort+"\t\t"+ UUID.randomUUID().toString();
    }
}
