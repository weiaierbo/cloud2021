package com.xxt.controller;

import com.xxt.dto.CommonResult;
import com.xxt.dto.OrderDTO;
import com.xxt.feign.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private OrderClientService orderClientService;

    private String url = "http://localhost/order/order";

    @RequestMapping("{id}")
    public CommonResult<OrderDTO> findById(@PathVariable Long id){
        return restTemplate.getForObject(url+"/"+id,CommonResult.class);
    }

    @RequestMapping("/ww")
    public CommonResult<String> findById2(){
        return CommonResult.buildSuccessData("xxxxx");
    }

    @RequestMapping("getName")
    public CommonResult<String> getName(){
        return CommonResult.buildSuccessData(orderClientService.getName());
    }


}
