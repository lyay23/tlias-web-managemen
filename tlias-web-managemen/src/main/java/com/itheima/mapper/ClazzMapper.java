package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/13:45
 * @Description: 班级管理的mapper
 */
@Mapper
public interface ClazzMapper {

    /**
     * 分页查询班级列表
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);
}
