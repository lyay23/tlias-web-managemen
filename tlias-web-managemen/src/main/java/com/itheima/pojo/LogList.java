package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/22:35
 * @Description: 日志分页查询实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogList {
    private Integer id;
    private Integer operateEmpId;
    private LocalDate operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private BigInteger costTime;

    //操作人姓名
    private String operateEmpName;

}
