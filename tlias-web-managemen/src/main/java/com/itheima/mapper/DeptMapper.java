package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/27/15:40
 * @Description: 操作部门数据
 */

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门数据
     * @return
     */
    @Select("select id, name, create_time , update_time  from dept order by id ")
    List<Dept> findAll();

    /**
     * 根据id删除部门信息
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
