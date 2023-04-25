package com.kuang.cloudalibaba.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String server_port;

    @GetMapping("/payment/getinfo/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return "nacos registry, serverPort: "+ server_port+"\t id"+id;
    }
}
