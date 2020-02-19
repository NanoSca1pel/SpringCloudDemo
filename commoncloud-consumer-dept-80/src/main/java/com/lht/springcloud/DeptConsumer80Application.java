package com.lht.springcloud;

import com.lht.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lhtao
 * @date 2019/8/8 16:41
 */
@SpringBootApplication
@EnableEurekaClient
//使用以下注解在启动该微服务的时候就能去加载我们的自定义Ribbon规则配置类，从而使配置生效
//@RibbonClient(name = "具体的微服务名称", configuration = 规则配置类.class)、
//由于规则配置类不能放在@ComponentScan所扫描的当前包下及其子包下，否则我们的自定义配置类就会被所有Ribbon客户端共享，就达不到特殊化定制的目的，所以MySelfRule.class需要在新的包下新建
@RibbonClient(name = "COMMONCLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80Application {

    public static void main(String[] args){

        SpringApplication.run(DeptConsumer80Application.class, args);
    }
}
