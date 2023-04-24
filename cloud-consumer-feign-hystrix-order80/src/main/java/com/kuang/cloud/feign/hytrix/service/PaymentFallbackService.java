package com.kuang.cloud.feign.hytrix.service;

import org.springframework.stereotype.Component;

/**
 * @Author: KX
 * @Description: openFeign服务降级实现类
 * @DateTime: 2023/4/24
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements ConsumerFeigHystrixService{
    @Override
    public String getPaymentInfo_ok(Long id) {
        return "服务调用失败，提示来自：cloud-consumer-openFeignHystric-order80";
    }

    @Override
    public String getPaymentInfo_timeout(Long id) {
        return "服务调用失败，提示来自：cloud-consumer-openFeignHystric-order80";
    }
}
