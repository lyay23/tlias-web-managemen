package com.itheima.mapper;

import com.itheima.pojo.LogList;
import com.itheima.pojo.LogQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/22:52
 * @Description: 日志分页查询
 */
@Mapper
public interface LogMapper {


    List<LogList> list(LogQueryParam logQueryParam);
}
