package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * @Author: 李阳
 * @Date: 2025/04/09/11:18
 * @Description:
 *
 */
@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam) ;

    /**
     * 分页查询-查询所有学员
     */

    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Integer id);

    /**
     * 新增学员
     */
    void save(Student student);

    /**
     * 根据id查询学员
     */
    Student findById(Integer id);

    /**
     * 修改学员
     */
    void update(Student student);

    /**
     * 批量删除学员
     */
    void delete(List<Integer> ids);

    void violation(Integer id, Integer score);
}
