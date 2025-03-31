package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/11:25
 * @Description:员工表
 */

@Data
public class Emp {
    //ID,主键
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //姓名
    private String name;
    //性别, 1:男, 2:女
    private Integer gender;
    //手机号
    private String phone;
    //职位, 1:班主任,2:讲师,3:学工主管,4:教研主管,5:咨询师
    private Integer job;
    //薪资
    private Integer salary;
    //头像
    private String image;
    //入职日期
    private LocalDate entryDate;
    //关联的部门ID
    private Integer deptId;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;

    //封装的部门名称
    private String deptName;
    // getter 和 setter 方法
    //封装工作经历的实体类
    private List<EmpExpr> exprList;

}