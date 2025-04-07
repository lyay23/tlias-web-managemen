package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.exception.BusinessException;
import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/13:35
 * @Description: 班级管理的实现类
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 班级管理-分页查询
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        //2.调用分页查询的方法
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        //3.封装结果并返回
        Page<Clazz> pageResult = (Page<Clazz>) clazzList;
        return new PageResult (pageResult.getTotal(),pageResult.getResult());
    }

    /**
     * 班级管理-根据id查询删除班级
     */
    @Override
    public void delete(Integer id) {
       Integer count=studentMapper.countByClazzId(id);
        if(count>0){
            // 这段代码抄人家的 不过实测使用RuntimeException也是一样的
            throw new BusinessException("该班级下有学生，不能删除");

        }
        //没有再删除
        clazzMapper.delete(id);

    }

    /**
     * 班级管理-新增班级
     * 有一个回显操作，回显所有班主任，不过不会写
     * 4月7日再次更新：
     * 解决了回显问题，要再emp接口中写查询所有员工的功能接口
     */
    @Override
    public void save(Clazz clazz) {
        //补全基本信息
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        //2.调用mapper接口插入数据
        clazzMapper.save(clazz);
    }

    /**
     * 班级管理-根据id查询班级
     */
    @Override
    public Clazz findById(Integer id) {
        return clazzMapper.findById(id);
    }

    /**
     * 班级管理-根据id修改班级
     */
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /**
     * 班级管理-查询所有班级
     */
    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }
}
