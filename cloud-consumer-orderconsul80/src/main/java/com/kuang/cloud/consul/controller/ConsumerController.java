package com.kuang.cloud.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    //z在consul注册的服务地址
    public static final String PAYMENT_URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul")
    public String getPaymentInfo() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul/get", String.class);
        return result;
    }
}
