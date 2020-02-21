package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lhtao
 * @date 2020/2/21 15:51
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerHystrixDashboard9001Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DeptConsumerHystrixDashboard9001Application.class, args);
    }
}
