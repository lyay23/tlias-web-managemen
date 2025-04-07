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
 * @Date: 2025/04/07/12:56
 * @Description:班级实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    //ID
    private Integer id;
    //班级名称
    private String name;
    //班级教室
    private String room;
    //开课时间
    private LocalDate beginDate;
    //结课时间
    private LocalDate endDate;
    //班主任
    private Integer masterId;
    //学科
    private Integer subject;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;

    //班主任姓名
    private String masterName;
    //班级状态 - 未开班 , 在读 , 已结课
    private String status;
}