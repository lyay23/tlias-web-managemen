package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/17:21
 * @Description: 员工管理的业务层实现类
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 基于PageHelper分页查询
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam){
        //1.设置分页参数
          PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        //2.调用分页查询的方法
        List<Emp> empList = empMapper.list(empQueryParam);
        //3.封装结果并返回
        Page<Emp> pageResult = (Page<Emp>) empList;
        return new PageResult<Emp>(pageResult.getTotal(),pageResult.getResult());
    }


}
