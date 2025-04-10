package com.itheima.service;

import com.itheima.pojo.LogList;
import com.itheima.pojo.LogQueryParam;
import com.itheima.pojo.PageResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/22:48
 * @Description: 日志分页查询
 */
public interface LogService {
    /**
     * 日志管理--分页查询
     */
    PageResult<LogList> page(LogQueryParam logQueryParam);
}
