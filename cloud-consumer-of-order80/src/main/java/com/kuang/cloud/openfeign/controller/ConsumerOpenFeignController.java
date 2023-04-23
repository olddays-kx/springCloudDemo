package com.kuang.cloud.openfeign.controller;

import com.kuang.cloud.entities.CommonResult;
import com.kuang.cloud.entities.Payment;
import com.kuang.cloud.openfeign.service.PaymentOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerOpenFeignController {

    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentOpenFeignService.getPaymentById(id);
    }
}
