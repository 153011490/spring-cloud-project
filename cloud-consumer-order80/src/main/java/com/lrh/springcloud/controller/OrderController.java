package com.lrh.springcloud.controller;

import com.lrh.springcloud.common.ServiceConfig;
import com.lrh.springcloud.entities.CommonResult;
import com.lrh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Resource
    RestTemplate restTemplate;

    @PostMapping(value = "/payment")
    public CommonResult<Payment> create(@RequestBody  Payment payment){
       return restTemplate.postForObject(ServiceConfig.PAYMENT_URL+"/payment",payment,CommonResult.class);
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(ServiceConfig.PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }
}
