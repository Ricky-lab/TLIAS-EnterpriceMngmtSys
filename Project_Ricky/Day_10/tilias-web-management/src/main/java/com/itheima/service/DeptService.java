package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * select all the depts
     * @return
     */
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void edit(Dept dept);
}
