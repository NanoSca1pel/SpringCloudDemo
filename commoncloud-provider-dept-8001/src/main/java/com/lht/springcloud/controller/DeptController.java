package com.lht.springcloud.controller;

import com.lht.springcloud.entity.Dept;
import com.lht.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lhtao
 * @date 2019/8/8 9:26
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;


    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("***********" + list);

        List<ServiceInstance> srvList = client.getInstances("COMMONCLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }
}
