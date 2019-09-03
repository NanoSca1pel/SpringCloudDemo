package com.lht.springcloud.cfgbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lhtao
 * @date 2019/8/8 11:11
 */
@Configuration
public class ConfigBean {  //boot -->spring   applicationContext.xml --- @Configuration配置 ConfigBean = applicationContext.xml

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
