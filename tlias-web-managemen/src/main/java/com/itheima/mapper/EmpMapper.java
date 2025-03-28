package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 分页查询员工数据
     * 这里我遇到了一些错误，是我的日期不匹配问题，我的驼峰命名不能正确转换
     *       所以我使用了@Results注解，将数据库中的字段和实体类中的字段进行映射
     *       但是我的application.yml中明明配置了map-underscore-to-camel-case: true
     *       还是不可以转换，后序如果有人能解决这个问题请告知我
     *       我的邮箱3050681193@qq.com
     */
    @Select("select e.*  , d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    @Results({
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "entryDate", column = "entry_date"),
    })
    public List<Emp> list();

}
