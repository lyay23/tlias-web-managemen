package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/13:34
 * @Description: 班级管理的service
 */
public interface ClazzService {

    /**
     * 班级管理--分页查询
     * @param clazzQueryParam
     * @return
     */
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 班级管理--新增班级
     */
    void save(Clazz clazz);


    /**
     * 班级管理--根据id删除班级
     */
    void delete(Integer id);

    /**
     * 班级管理--根据id查询班级
     */
    Clazz findById(Integer id);

    /**
     * 班级管理--根据id修改班级
     */
    void update(Clazz clazz);

    /**
     * 班级管理--查询所有班级
     */
    List<Clazz> findAll();
}
