package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/11:26
 * @Description: 工作经历表
 */
@Data
public class EmpExpr {
    //ID
    private Integer id;
    //员工ID
    private Integer empId;
    //开始时间
    private LocalDate begin;
    //结束时间
    private LocalDate end;
    //公司名称
    private String company;
    //职位
    private String job;
}