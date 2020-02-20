package com.lht.springcloud.controller;

import com.lht.springcloud.entity.Dept;
import com.lht.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource(name = "discoveryClient")
    private DiscoveryClient client;


    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping("/get/{id}")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {

        Dept dept = service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有对应的信息");
        }
        return dept;
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


    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptNo(id).setDeptName("该ID：" + id + "没有对应的信息,null--@HystrixCommand").setDbSource("No this data in Mysql");
    }
}
