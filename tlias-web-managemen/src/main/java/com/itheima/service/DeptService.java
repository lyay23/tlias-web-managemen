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
     * 查询所有部门数据
     * @return
     */
    List<Dept> findAll();
}
