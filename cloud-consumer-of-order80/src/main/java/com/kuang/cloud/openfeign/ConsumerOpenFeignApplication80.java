package com.kuang.cloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOpenFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignApplication80.class, args);
    }
}
