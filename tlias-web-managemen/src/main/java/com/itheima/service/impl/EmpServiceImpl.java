package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import com.itheima.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private EmpLogService empLogService;

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

    @Transactional //事务管理
    @Override
    public void save(Emp emp) {
        try {
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
        } finally {
            //记录日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工:"+emp);
            empLogService.insertLog(empLog);
        }


    }

    /**
     * 批量删除员工 包括事务两个一起成功
     */
    @Transactional(rollbackFor = {Exception.class}) //事务管理-出现异常都需要回滚
    @Override
    public void delete(List<Integer> ids) {
        //1.批量删除员工基本信息
        empMapper.deleteByIds(ids);

        //2.批量删除员工工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }



    /**
     * 根据id查询员工信息
     */
    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    /**
     * 修改员工信息
     */
    @Transactional(rollbackFor = Exception.class) //事务管理
    @Override
    public void update(Emp emp) {
        //1. 根据id修改员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //2. 根据id修改员工工作经历信息--先删除再添加
        //2.1 删除员工工作经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        //2.2 添加员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }

    }

    /**
     * 员工登录
     */
    @Override
    public LoginInfo login(Emp emp) {

        //1. 根据用户名查询员工信息
        Emp e= empMapper.selectByUsernameAndPwd(emp);
        //2. 判断员工是否存在，如果存在组装登陆成功的信息
        if (e!=null){
            log.info("员工登录成功:{}",e);

            //生成JWT令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateToken(claims);

            return new LoginInfo(e.getId(),e.getUsername(),e.getName(),jwt);
        }
        // 3. 如果员工不存在，返回登陆失败的信息
        return null;
    }
}
