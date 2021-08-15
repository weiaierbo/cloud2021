package com.xk.controller;

import com.xk.dto.CommonResult;
import com.xk.dto.OrderDTO;
import com.xk.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xk
 * @create 2021.08.04 19:43
 */
@RequestMapping("order")
@RestController
public class OrderController {

    @Resource
    private OrderService  orderService;

    @RequestMapping("{id}")
    public CommonResult<OrderDTO> findById(@PathVariable Long id){
        return CommonResult.buildSuccessData(orderService.findById(id));
    }

    @RequestMapping("/12/{id}")
    public CommonResult<OrderDTO> findById2(@PathVariable Long id){
        return CommonResult.buildSuccessData(orderService.findById(id));
    }
}
