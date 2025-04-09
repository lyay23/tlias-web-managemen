package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/09/10:50
 * @Description: 学员管理的业务层接口
 */
public interface StudentService {

    /**
     * 学员管理-分页查询
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 学员管理-新增
     */
    void add(Student student);

    /**
     * 学员管理-根据id查询学员
     */
    Student findById(Integer id);

    /**
     * 学员管理-修改
     */
    void update(Student student);
}
