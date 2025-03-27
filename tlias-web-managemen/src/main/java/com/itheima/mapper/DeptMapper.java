package com.itheima.mapper;

import com.itheima.pojo.Dept;
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
}
