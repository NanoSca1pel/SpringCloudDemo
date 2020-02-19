package com.lht.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lhtao
 * @date 2019/8/8 11:11
 */
@Configuration
public class ConfigBean {  //boot -->spring   applicationContext.xml --- @Configuration配置 ConfigBean = applicationContext.xml

    @Bean(name = "myRestTemplate")
    @LoadBalanced //SpringCloud Ribbon开启负载均衡的注解，默认的算法是轮询算法
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){

        //Ribbon的负载均衡算法设置成随机算法
        //return new RandomRule();

        //设置成重试算法
        return new RetryRule();
    }
}
