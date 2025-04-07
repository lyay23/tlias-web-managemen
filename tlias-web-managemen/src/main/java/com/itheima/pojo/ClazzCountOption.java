package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/12:57
 * @Description: 班级模块柱状图饼图的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzCountOption {
    //职位列表
    private List clazzList;
    //人数列表
    private List dataList;
}
