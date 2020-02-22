package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lhtao
 * @date 2020-02-22 20:03
 */
@SpringBootApplication
@EnableConfigServer  //开启springcloud配置中心服务端
public class SpringCloudConfigServer3344Application {

    public static void main(String[] args){
        SpringApplication.run(SpringCloudConfigServer3344Application.class, args);
    }
}
