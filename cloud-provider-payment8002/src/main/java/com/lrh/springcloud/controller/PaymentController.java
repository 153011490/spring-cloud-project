package com.lrh.springcloud.controller;

import com.lrh.springcloud.entities.CommonResult;
import com.lrh.springcloud.entities.Payment;
import com.lrh.springcloud.entities.common.ResponseCode;
import com.lrh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert result: "+result);

        if(result > 0){
            return new CommonResult(ResponseCode.CREATED,"Crate successfully,server port:"+serverPort,result);
        }else{
            return new CommonResult(ResponseCode.BAD_REQUEST,"Crate fail,server port:"+serverPort,null);
        }
    }

    @GetMapping(value = "/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(ResponseCode.OK,"Select successfully,server port:"+serverPort,payment);
        }else {
            return new CommonResult(ResponseCode.NOT_FOUND,"No record,server port:"+serverPort,null);
        }
    }

}
