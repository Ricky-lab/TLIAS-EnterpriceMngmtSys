package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j

@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts", method = RequestMethod.GET)//只等
    @GetMapping()
    public Result list(){
        //调用service查询部门数据
        log.info("Select all the depts successfully! ");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("Delete the dept where id is: {}", id);

        deptService.delete(id);
        return Result.success();
    }

    @PostMapping()
    //The annotation is @RequestBody not PathVariable
    public Result add(@RequestBody Dept dept){
        log.info("Insert the new dept where name is: {}", dept);

        deptService.add(dept);
        return Result.success();
    }

    @PutMapping()
    public Result edit(@RequestBody Dept dept){
        log.info("Edit the current dept and then save the change");
        deptService.edit(dept);
        return Result.success();
    }
}
