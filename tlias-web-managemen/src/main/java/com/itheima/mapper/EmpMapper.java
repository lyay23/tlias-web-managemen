package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/17:18
 * @Description: 操作员工信息的持久层接口
 */
@Mapper
public interface EmpMapper {

   // @Select("select e.*  , d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")

    /**
     * 条件查询员工信息
     */
    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     */

    void insert(Emp emp);

    /**
     * 批量根据id删除员工基本信息
     */
    void deleteByIds(List<Integer> ids);
}
