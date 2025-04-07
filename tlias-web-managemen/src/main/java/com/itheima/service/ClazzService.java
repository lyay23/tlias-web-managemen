package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/13:34
 * @Description: 班级管理的service
 */
public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);
}
