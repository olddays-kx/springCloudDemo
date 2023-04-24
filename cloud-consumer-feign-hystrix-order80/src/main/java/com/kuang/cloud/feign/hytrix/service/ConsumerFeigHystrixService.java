package com.kuang.cloud.feign.hytrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: KX
 * @Description: 服务降级
 * @DateTime: 2023/4/24
 * @Version 1.0
 */

@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface ConsumerFeigHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String getPaymentInfo_ok(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String getPaymentInfo_timeout(@PathVariable("id") Long id);
}
