package com.lht.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lhtao
 * @date 2020-02-22 16:12
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableZuulProxy //启动Zuul代理,启用网关代理后可以使用 http://网关地址:网关端口号/应用提供微服务名(项目名)/具体rest风格服务接口url。如果做了路由映射，可以用映射的url段替代微服务名
public class SpringCloudStartZuul9527Application {

    public static void main(String[] args){
        SpringApplication.run(SpringCloudStartZuul9527Application.class, args);
    }
}
