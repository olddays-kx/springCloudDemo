package com.kuang.cloud.openfeign.service;

import com.kuang.cloud.entities.CommonResult;
import com.kuang.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "cloud-payment-service")
public interface PaymentOpenFeignService {

    /**
     * @Description: getMapping的地址时提服务端的访问地址 这里时8001 8002controller的
     * @Author: KX
     * @Date: 2023/4/23
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
