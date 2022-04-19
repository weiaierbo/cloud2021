package com.xxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xk
 * @since 2021.08.05 15:01
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class,args);
    }
}
