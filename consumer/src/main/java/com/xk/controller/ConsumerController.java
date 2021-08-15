package com.xk.controller;

import com.xk.dto.CommonResult;
import com.xk.dto.OrderDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xk
 * @since 2021.08.05 15:02
 */
@RequestMapping("consumer")
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private String url = "http://localhost/order/order";

    @RequestMapping("{id}")
    public CommonResult<OrderDTO> findById(@PathVariable Long id){
        return restTemplate.getForObject(url+"/"+id,CommonResult.class);
    }

    @RequestMapping("/ww")
    public CommonResult<String> findById2(){
        return CommonResult.buildSuccessData("xxxxx");
    }


}
