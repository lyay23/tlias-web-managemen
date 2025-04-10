package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.LogList;
import com.itheima.pojo.LogQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/22:48
 * @Description: 日志分页查询
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<LogList> page(LogQueryParam logQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(logQueryParam.getPage(),logQueryParam.getPageSize());
        //2.调用分页查询的方法
        List<LogList> clazzList =logMapper.list(logQueryParam);
        //3.封装结果并返回
        Page<LogList> pageResult = (Page<LogList>) clazzList;
        return new PageResult<LogList>(pageResult.getTotal(),pageResult.getResult());
    }
}
