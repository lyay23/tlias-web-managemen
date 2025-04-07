package com.itheima.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/18:45
 * @Description:
 */
@Mapper
public interface StudentMapper {
    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Integer id);
}
