package com.lht.service;

import com.lht.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lhtao
 * @date 2020/2/19 16:45
 */
@FeignClient("COMMONCLOUD-DEPT")
@RequestMapping("/dept")
public interface DeptClientService {

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping("/list")
    public List<Dept> list();

    @PostMapping("/add")
    public boolean add(Dept dept);
}
