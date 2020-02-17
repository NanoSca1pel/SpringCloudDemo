package com.lht.springcloud.controller;

import com.lht.springcloud.cfgbean.ConfigBean;
import com.lht.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lhtao
 * @date 2019/8/8 16:11
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private ConfigBean configBean;

    /**
     * 使用RestTemplate访问result接口非常的简单粗暴无脑
     * (url, request, responseType)这三个参数分别代表
     * REST请求地址, 请求参数, Http响应转换被转换成的对象类型
     * @param dept
     * @return
     */
    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return configBean.getRestTemplate().postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }


    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return configBean.getRestTemplate().getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }



    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list() {
        return configBean.getRestTemplate().getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    //测试@EnableDiscoveryClient，消费端可以调用服务发现
    @GetMapping("/discovery")
    public Object discovery() {
        return configBean.getRestTemplate().getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
