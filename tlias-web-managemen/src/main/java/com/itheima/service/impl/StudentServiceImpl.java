package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/09/10:50
 * @Description: 学员管理的业务层接口的实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;



    /**
     * 学员管理-分页查询
     */
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        //2.调用分页查询的方法
        List<Student> studentList = studentMapper.list(studentQueryParam);
        //3.封装结果并返回
        Page<Student> pageResult = (Page<Student>) studentList;
        return new PageResult<Student> (pageResult.getTotal(),pageResult.getResult());
    }

    /**
     * 学员管理-新增
     */
    @Override
    public void add(Student student) {
        //补全基本信息
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        //2.调用mapper接口插入数据
        studentMapper.save(student);
    }

    @Override
    public Student findById(Integer id) {

        return studentMapper.findById(id);
    }
}
