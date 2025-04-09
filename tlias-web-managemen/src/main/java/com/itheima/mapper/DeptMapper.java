package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

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
     */
    @Select("select id, name, create_time , update_time  from dept order by id ")
    List<Dept> findAll();

    /**
     * 根据id删除部门信息
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门信息
     */
    @Insert("insert into dept(name, create_time , update_time ) values(#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    /**
     * 根据id查询部门信息
     */
    @Select("select id, name, create_time  , update_time  from dept where id = #{id}")
    Dept getInfo(Integer id);

    /**
     * 更新部门信息
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    /**
     * 统计指定部门下的员工数量
     */
    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{deptId}")
    Integer countEmployeesByDeptId(Integer deptId);
}
