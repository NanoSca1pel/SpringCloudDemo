package com.lht.springcloud.service;

import com.lht.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lhtao
 * @date 2020-02-20 20:27
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {


    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptNo(id).setDeptName("该ID：" + id + "没有对应的信息,Consumer客户端提供的降级信,此刻服务Provider已经关闭--@HystrixCommand").setDbSource("No this data in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
