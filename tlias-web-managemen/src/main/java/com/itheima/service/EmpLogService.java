package com.itheima.service;

import com.itheima.pojo.EmpLog;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/31/18:44
 * @Description: 事务监听
 */
@Service
public interface EmpLogService {
    public void insertLog(EmpLog empLog);
}
