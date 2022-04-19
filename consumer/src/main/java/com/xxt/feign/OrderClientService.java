package com.xxt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xk
 * @since 2022.04.19 18:55
 */
@FeignClient("order")
public interface OrderClientService {
    @RequestMapping("order/nacos/getName")
    public String getName();
}
