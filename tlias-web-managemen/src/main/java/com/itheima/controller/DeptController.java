package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/27/15:43
 * @Description: 部门控制层
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
      List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}
