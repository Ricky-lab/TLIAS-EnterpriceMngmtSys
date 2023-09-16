package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("");
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    @Log
    public Result delete(@PathVariable List<Integer> ids){
        log.info("Combining deletion");
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    @Log
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    @PutMapping
    @Log
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}
