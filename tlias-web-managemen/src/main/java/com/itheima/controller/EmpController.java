package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
   public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询员工信息,参数：{}", empQueryParam);
        PageResult<Emp> pageResult= empService.page(empQueryParam);
       return Result.success(pageResult);
   }

   /**
    * 员工管理--新增员工
    */
   @PostMapping
   public Result save(@RequestBody Emp emp){
       log.info("新增员工信息,参数：{}", emp);
       empService.save(emp);
       return Result.success();
   }
}
