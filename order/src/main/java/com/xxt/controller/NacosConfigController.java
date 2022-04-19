package com.xxt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xk
 * @since 2022.04.19 17:20
 */
@RefreshScope
@RequestMapping("nacos")
@RestController
public class NacosConfigController {

    @Value("${name}")
    private String name;

    @RequestMapping("getName")
    public String getName(){
        return name;
    }

    @Value("${age}")
    private String age;

    @RequestMapping("getAge")
    public String getAge(){
        return age;
    }
}
