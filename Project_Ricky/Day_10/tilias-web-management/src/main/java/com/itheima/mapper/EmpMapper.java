package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);
    //@Select("select * from emp ")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * delete in batches
     * @param ids
     */
    void delete(List<Integer> ids);
}
