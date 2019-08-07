package com.lht.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lhtao
 * @date 2019-07-25 16:06
 */
@Data
@ToString
@SuppressWarnings("serial")
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable { //必须序列化

    private Long deptNo; //主键
    private String deptName; //部门名称
    private String dbSource; //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库中

    public Dept(String deptName) {
        this.deptName = deptName;
    }

    public static void main(String[] args){
        Dept dept = new Dept();
        dept.setDeptNo(11L).setDeptName("RD").setDbSource("DB01");
        System.out.println(dept.toString());
    }
}
