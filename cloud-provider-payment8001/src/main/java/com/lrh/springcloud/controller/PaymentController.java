package com.lrh.springcloud.controller;

import com.lrh.springcloud.common.ResponseCode;
import com.lrh.springcloud.entities.CommonResult;
import com.lrh.springcloud.entities.Payment;
import com.lrh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert result: "+result);

        if(result > 0){
            return new CommonResult(ResponseCode.CREATED,"Crate successfully",result);
        }else{
            return new CommonResult(ResponseCode.BAD_REQUEST,"Crate fail",null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(ResponseCode.OK,"Select successfully",payment);
        }else {
            return new CommonResult(ResponseCode.NOT_FOUND,"No record",null);
        }
    }

}
