package com.kuang.cloud.feign.hytrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //熔断服务降级
public class ConsumerFeignHysrixApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHysrixApplication80.class, args);
    }
}
