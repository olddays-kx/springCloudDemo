package com.kuang.cloud.hystrix.servic;

public interface PaymentHystrixService {

    String paymentInfoOK(Long id);
    //服务降级
    String paymentInfoTimeOut(Long id);
    //服务降级
    String paymentInfoTimeOutGlobal(Long id);
    //服务熔断
    String paymentCircuitBreaker(Long id);
}
