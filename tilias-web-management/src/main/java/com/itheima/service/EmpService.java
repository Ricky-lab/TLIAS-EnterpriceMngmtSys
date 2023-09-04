package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * Select pageSize per page
     * @param page: page index
     * @param pageSize: page size of each page.
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    /**
     * new a emp
     * @param emp
     */
    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);
}
