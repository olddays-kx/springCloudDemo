package com.kuang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentApplicationZK8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationZK8004.class, args);
    }
}
