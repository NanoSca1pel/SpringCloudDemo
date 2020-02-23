package com.lht.springcloud.service.impl;

import com.lht.springcloud.dao.DeptDao;
import com.lht.springcloud.entity.Dept;
import com.lht.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lhtao
 * @date 2019/8/7 16:15
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        List<Dept> all = deptDao.findAll();
        return all;
    }
}
