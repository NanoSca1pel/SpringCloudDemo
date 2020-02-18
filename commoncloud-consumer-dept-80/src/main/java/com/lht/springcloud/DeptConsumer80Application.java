package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lhtao
 * @date 2019/8/8 16:41
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer80Application {

    public static void main(String[] args){

        SpringApplication.run(DeptConsumer80Application.class, args);
    }
}
