package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lhtao
 * @date 2019/8/8 16:41
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lht.springcloud"})
public class DeptConsumerFeign80Application {

    public static void main(String[] args){

        SpringApplication.run(DeptConsumerFeign80Application.class, args);
    }
}
