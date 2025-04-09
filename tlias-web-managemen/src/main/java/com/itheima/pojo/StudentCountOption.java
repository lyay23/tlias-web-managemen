package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/09/17:19
 * @Description: 学员统计模块-柱状图饼图
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCountOption {
    private List clazzList;
    private List dataList;


}
