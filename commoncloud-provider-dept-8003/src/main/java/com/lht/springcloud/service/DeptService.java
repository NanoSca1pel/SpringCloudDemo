package com.lht.springcloud.service;

import com.lht.springcloud.entity.Dept;

import java.util.List;

/**
 * @author lhtao
 * @date 2019/8/7 16:13
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
