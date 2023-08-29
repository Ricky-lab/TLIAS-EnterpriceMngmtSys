package com.itheima.service;

import com.itheima.pojo.PageBean;

public interface EmpService {
    /**
     * Select pageSize per page
     * @param page: page index
     * @param pageSize: page size of each page.
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
