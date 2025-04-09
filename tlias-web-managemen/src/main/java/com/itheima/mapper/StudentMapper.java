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
}
