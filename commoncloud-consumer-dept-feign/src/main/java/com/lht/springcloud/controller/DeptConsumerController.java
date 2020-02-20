package com.lht.springcloud.controller;

import com.lht.springcloud.service.DeptClientService;
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

    @Autowired
    private DeptClientService deptClientService;

    /**
     * 使用RestTemplate访问result接口非常的简单粗暴无脑
     * (url, request, responseType)这三个参数分别代表
     * REST请求地址, 请求参数, Http响应转换被转换成的对象类型
     * @param dept
     * @return
     */
    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return deptClientService.add(dept);
    }


    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }



    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list() {
        return deptClientService.list();
    }
}
