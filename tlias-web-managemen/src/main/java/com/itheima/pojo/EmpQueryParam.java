package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/31/10:35
 * @Description: 分页查询实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam {
    // 当前页
    private Integer page=1;
    // 每页显示条数
    private Integer pageSize=10;
    // 姓名
    private String name;
    // 性别
    private Integer gender;
    // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    // 结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
