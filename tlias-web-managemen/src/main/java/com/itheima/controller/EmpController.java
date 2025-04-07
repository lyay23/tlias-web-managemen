package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   /**
    * 员工管理--删除员工
    */
  /* 方式一：使用数组
   @DeleteMapping
   public Result delete(Integer[] ids){
       log.info("删除员工信息,参数：{}", Arrays.toString(ids));
       empService.delete(id);
       return Result.success();
   }
   */
   //使用集合
   @DeleteMapping
   public Result delete(@RequestParam List<Integer> ids){
       log.info("删除员工信息,参数：{}", ids);
       empService.delete(ids);
       return Result.success();
   }

    /**
     * 员工管理--修改员工
     */
    // 根据id回显
    @GetMapping("/{id}")
    // @PathVariable 用于获取路径参数
    public Result getEmp(@PathVariable Integer id){
        log.info("根据id查询员工信息,参数：{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    // 修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息,参数：{}", emp);
        empService.update(emp);
        return Result.success();
    }

    /**
     * 员工管理--查询所有员工
     */
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有员工信息");
        List<Emp> empList = empService.findAll();
        return Result.success(empList);
    }
}
