package com.kuang.cloud.consumer.controller;

import com.kuang.cloud.entities.CommonResult;
import com.kuang.cloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerOrderController {

    private static final String PAYMNET_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMNET_URL+ "/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/paymen/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMNET_URL + "/payment/get/" + id, CommonResult.class);
    }
}
