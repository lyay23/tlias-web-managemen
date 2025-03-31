package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/17:21
 * @Description: 员工管理的业务层实现类
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
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

    /**
     * 增加员工，保留员工工作经历信息
     */
    @Override
    public void save(Emp emp) {
        //1.保存员工信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        //2.保存员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        // 判断集合不为空
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            // 添加日志，查看数据
            log.info("员工工作经历数据: {}", exprList);
            empExprMapper.insertBatch(exprList);
        }
    }

}
