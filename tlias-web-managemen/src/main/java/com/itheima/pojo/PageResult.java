package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/28/19:02
 * @Description: 分页查询返回的数据实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult <T>{
    //页码
    private Long total;
    //当前页数据
    private List<T> rows;


}
