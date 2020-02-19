package com.lht.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhtao
 * @date 2020/2/19 13:50
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //return new RandomRule(); //Ribbon默认的负载均衡算法是轮询，这里改为随机
        return new MyRoundRobinRule();
    }
}
