package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/27/15:41
 * @Description: 操作部门信息的业务层接口
 */

public interface DeptService {

    /**
     * 部门管理-查询所有部门数据
     */
    List<Dept> findAll();

    /**
     * 部门管理根据id删除部门信息
     */
    void deleteById(Integer id);


    /**
     * 部门管理-添加部门信息
     */
    void add(Dept dept);

    /**
     * 部门管理-根据id查询部门信息
     */
    Dept getInfo(Integer id);

    /**
     * 部门管理-修改部门信息
     */
    void update(Dept dept);
}
