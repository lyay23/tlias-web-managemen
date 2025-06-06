package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/13:23
 * @Description: 班级管理的一些列操作
 */

@RestController
@Slf4j
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 班级管理--分页查询
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询班级信息,参数：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 班级管理--新增班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("新增班级信息,参数：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 班级管理--删除指定班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        try {
            clazzService.delete(id);
            log.info("删除班级信息,参数：{}", id);
            return Result.success();
        } catch (BusinessException e) {
            // 捕获业务异常，返回错误信息给前端
            log.error("删除班级失败：{}", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 班级管理--根据id查询班级
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        log.info("根据id查询班级信息,参数：{}", id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    /**
     * 班级管理--根据id修改班级
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级信息,参数：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 班级管理--查询所有班级
     */
    @GetMapping("/list")
    public Result findAll() {
       List<Clazz> clazzList= clazzService.findAll();
        log.info("查询所有班级信息");
        return Result.success(clazzList);
    }
}