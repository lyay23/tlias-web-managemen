package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/17:22
 * @Description: 员工管理的控制器
 */
@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    /**
     * 员工管理--分页查询
     */
    @GetMapping
   public Result page(Integer page, Integer pageSize){
        log.info("分页查询员工信息,当前页码：{},每页显示条数：{}",page,pageSize);
        PageResult<Emp> pageResult= empService.page(page,pageSize);
       return Result.success(pageResult);
   }
}
