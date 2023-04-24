package com.kuang.cloud.hystrix.servic;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
/**
 * @Author: KX
 * @Description: 服务降级
 * @DateTime: 2023/4/24
 * @Version 1.0
 */

@Service
@DefaultProperties(defaultFallback = "paymentInfoTimeoutGlobalHandler")
public class PaymentHystixServiceImpl implements PaymentHystrixService{

    @Override
    public String paymentInfoOK(Long id) {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    /**
     * 超时访问，设置自身调用超时的峰值，峰值内正常运行，超过了峰值需要服务降级 自动调用fallbackMethod 指定的方法
     * 超时异常或者运行异常 都会进行服务降级
     * 服务降级
     * @param id
     * @return
     */
    @Override
    //指定服务降级回调方法
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties =
            {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")})
    public String paymentInfoTimeOut(Long id) {
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }

    //服务降级
    @Override
    @HystrixCommand
    public String paymentInfoTimeOutGlobal(Long id) {
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费5秒";
    }

    public String paymentInfoTimeOutHandler(Long id) {
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }

    public String paymentInfoTimeoutGlobalHandler() {
        return "GLOBAL.../(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }


    @Override
    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //开启服务熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //快照窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //在快照窗口期失败率
    })

    public String paymentCircuitBreaker(Long id) {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Long id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
