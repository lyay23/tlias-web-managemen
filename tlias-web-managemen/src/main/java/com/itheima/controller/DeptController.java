package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/27/15:43
 * @Description: 部门控制层
 */
@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 部门管理--查询所有部门
     * @return
     */
    @GetMapping("/depts")
    public Result list(){
      List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 部门管理--删除指定部门
     * @return
     */
    @DeleteMapping("/depts")
   public Result delete( Integer id){
        deptService.deleteById(id);
        log.info("删除部门id为：{}",id);
        return Result.success();
   }

   /**
    * 部门管理--添加部门
    * @return
    */
   @PostMapping("/depts")
   public Result add(@RequestBody Dept dept){
       deptService.add(dept);
       log.info("添加部门:{}",dept);
       return Result.success();
   }

   /**
    * 部门管理--修改部门
    * @return
    */
   //首先要根据这个id查询出这个部门，实现回显操作
   @GetMapping("/depts/{id}")
   public Result getInfo(@PathVariable Integer id){
       log.info("查询部门id为：{}",id);
       Dept dept=deptService.getInfo(id);
       //查询成功就返回这个部门
       return Result.success(dept);
   }
   //根据id修改部门
   @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
       deptService.update(dept);
       log.info("修改部门:{}",dept);
       return Result.success();
   }

}
