package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/09/20:53
 * @Description: 登录页面的控制器
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private EmpService empService;
    /**
     * 登录模块-登录功能
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
       log.info("登录：{}", emp);
       LoginInfo info= empService.login(emp);
       if (info != null){
           return Result.success(info);
       }
       return Result.error("用户名或密码错误");
    }

}
