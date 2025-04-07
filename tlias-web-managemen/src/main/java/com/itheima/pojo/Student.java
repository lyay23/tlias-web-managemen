package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/12:52
 * @Description: 学生表的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    //ID
    private Integer id;
    //姓名
    private String name;
    //学号
    private String no;
    //性别 , 1: 男 , 2 : 女
    private Integer gender;
    //手机号
    private String phone;
    //身份证号
    private String idCard;
    //是否来自于院校, 1: 是, 0: 否
    private Integer isCollege;
    //联系地址
    private String address;
    //最高学历, 1: 初中, 2: 高中 , 3: 大专 , 4: 本科 , 5: 硕士 , 6: 博士
    private Integer degree;
    //毕业时间
    private LocalDate graduationDate;
    //班级ID
    private Integer clazzId;
    //违纪次数
    private Short violationCount;
    //违纪扣分
    private Short violationScore;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;
    //班级名称
    private String clazzName;
}
