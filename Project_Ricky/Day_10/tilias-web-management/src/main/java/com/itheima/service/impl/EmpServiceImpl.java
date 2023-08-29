package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. total pages - total
        Long count = empMapper.count();

        //2. get the results of paging query
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        //3. package the return bean object
        PageBean pageBean = new PageBean(count,empList);
        return pageBean;
    }
}
