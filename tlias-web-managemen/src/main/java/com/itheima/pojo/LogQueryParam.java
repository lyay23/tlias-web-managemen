package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/22:45
 * @Description: 日志分页查询实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogQueryParam {
    private Integer page=1;
    private Integer pageSize=10;

}
