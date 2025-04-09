package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/09/10:46
 * @Description: 学员分页查询的响应参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    // 学员姓名
    private String name;
    // 学员学历
    private Integer degree;
    // 学员班级ID
    private Integer clazzId;
    // 当前页码
    private Integer page=1;
    // 每页显示条数
    private Integer pageSize=10;


}
