package com.kuang.cloud.hystrix.controller;

import com.kuang.cloud.hystrix.servic.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: KX
 * @Description: 服务降级 服务熔断
 * @DateTime: 2023/4/24
 * @Version 1.0
 */

@RestController
public class PaymentHysrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfoOK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    @GetMapping("/payment/hystrix/timeoutglobal/{id}")
    public String paymentInfo_TimeOutGlobal(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentInfoTimeOutGlobal(id);
    }

    //服务熔断
    @GetMapping("/payment/hystrix/circuitbreaker/{id}")
    public String paymentInfoCircuitBreaker(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentCircuitBreaker(id);
    }
}
