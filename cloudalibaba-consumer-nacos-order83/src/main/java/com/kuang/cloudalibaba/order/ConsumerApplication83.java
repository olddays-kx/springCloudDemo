package com.kuang.cloudalibaba.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication83.class, args);
    }
}
