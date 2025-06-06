package com.itheima.service.impl;

import com.itheima.exception.BusinessException;
import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/27/15:41
 * @Description: 操作部门信息的业务层接口
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private  DeptMapper deptMapper;


    /**
     * 查询所有部门数据
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /**
     * 根据id删除部门信息
     */
    @Override
    public void deleteById(Integer id) {
        // 统计该部门下的员工数量
        Integer employeeCount = deptMapper.countEmployeesByDeptId(id);
        if (employeeCount > 0) {
            // 如果部门下有员工，则抛出业务异常
            throw new BusinessException("对不起，当前部门下有员工，不能直接删除！");
        }
        // 部门下没有员工，执行删除操作
        deptMapper.deleteById(id);
    }

    /**
     * 添加部门信息
     */
    @Override
    public void add(Dept dept) {

        //1.补全基本属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        //2.调用mapper接口插入数据
        deptMapper.add(dept);
    }

    /**
     * 根据id查询部门信息
     */
    @Override
    public Dept getInfo(Integer id) {
        return deptMapper.getInfo(id);
    }

    /**
     * 修改部门信息
     */
    @Override
    public void update(Dept dept) {
         //1.补全基本属性
        dept.setUpdateTime(LocalDateTime.now());

        //2.调用mapper接口插入数据
        deptMapper.update(dept);

    }
}
