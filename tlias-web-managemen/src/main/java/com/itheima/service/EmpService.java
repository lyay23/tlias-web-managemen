package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/17:20
 * @Description: 员工管理的业务层接口
 */

public interface EmpService {
    /**
     * 员工管理-分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 员工管理--新增员工
     */
    void save(Emp emp);
}
