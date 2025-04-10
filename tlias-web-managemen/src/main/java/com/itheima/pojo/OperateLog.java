package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/20:47
 * @Description: AOP日志操作实体类
 */
@Data
public class OperateLog {
    //ID
    private Integer id;
    //操作人ID
    private Integer operateEmpId;
    //操作时间
    private LocalDateTime operateTime;
    //操作类名
    private String className;
    //操作方法名
    private String methodName;
    //操作方法参数
    private String methodParams;
    //操作方法返回值
    private String returnValue;
    //操作耗时
    private Long costTime;
}