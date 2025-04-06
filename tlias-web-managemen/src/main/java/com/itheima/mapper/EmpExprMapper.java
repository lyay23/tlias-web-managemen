package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/17:19
 * @Description: 员工工作经历的数据访问层接口
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工id删除员工工作经历
     */
    void deleteByEmpIds(List<Integer> empIds);
}
