package com.kuang.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApplication8006.class, args);
    }
}
