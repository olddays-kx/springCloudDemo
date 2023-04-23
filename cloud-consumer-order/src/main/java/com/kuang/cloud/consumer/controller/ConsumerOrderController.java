package com.kuang.cloud.consumer.controller;

import com.kuang.cloud.entities.CommonResult;
import com.kuang.cloud.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerOrderController {

    //服务注册的地址
    private static final String PAYMNET_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMNET_URL+ "/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMNET_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getentity/{id}")
    public CommonResult<Payment> getPaymentbyId(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> result = restTemplate.getForEntity(PAYMNET_URL + "/payment/get/" + id,
                CommonResult.class);
        if (result.getStatusCode().is2xxSuccessful()) {
            return result.getBody();
        } else {
            return new CommonResult(400, "查找失败", null);
        }
    }

    @GetMapping("/consumer/payment/createbypost")
    public CommonResult<Payment> postPaymentEntity(@RequestBody Payment payment) {
        ResponseEntity<Payment> entity = restTemplate.postForEntity(PAYMNET_URL + "/payment/create", payment, Payment.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult(200, "插入成功", null);
        } else {
            return new CommonResult(400, "查找失败", null);
        }
    }
}
