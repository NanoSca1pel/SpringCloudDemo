package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lhtao
 * @date 2020-02-23 12:50
 */
@SpringBootApplication
@EnableEurekaServer
public class  SpringCloudConfigEurekaServer7001Application {

    public static void main(String[] args){
        SpringApplication.run(SpringCloudConfigEurekaServer7001Application.class, args);
    }
}
