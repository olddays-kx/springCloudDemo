package com.kuang.cloud.myselfrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: KX
 * @Description: 替换ribbon默认的轮询的负载均衡算法选择随机规则
 * @DateTime: 2023/4/23
 * @Version 1.0
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
