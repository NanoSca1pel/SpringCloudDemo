package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lhtao
 * @date 2019/8/16 16:29
 */
@SpringBootApplication
@EnableEurekaServer //EurekaServer服务器端启动类，接受其他微服务注册进来
public class EurekaServer7001Application {

    public static void main(String[] args){
        SpringApplication.run(EurekaServer7001Application.class, args);
    }
}
