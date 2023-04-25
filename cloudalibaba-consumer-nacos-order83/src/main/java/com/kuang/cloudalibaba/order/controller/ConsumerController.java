package com.kuang.cloudalibaba.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Value("${service-url.nacos-user-service}")
    private String paymentURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer//payment/getinfo/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(paymentURL + "/payment/getinfo/" + id, String.class);
    }
}
