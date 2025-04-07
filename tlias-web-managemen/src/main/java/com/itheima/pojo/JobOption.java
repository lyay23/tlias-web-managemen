package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/8:30
 * @Description: 柱状图的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {

    //职位列表
    private List jobList;
    //数据列表
    private List dataList;
}
