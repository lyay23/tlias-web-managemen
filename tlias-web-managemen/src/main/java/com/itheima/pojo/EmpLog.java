package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/03/31/18:35
 * @Description: 事务日志
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpLog {
    //ID
    private Integer id;
    //操作时间
    private LocalDateTime operateTime;
    //详细信息
    private String info;
}