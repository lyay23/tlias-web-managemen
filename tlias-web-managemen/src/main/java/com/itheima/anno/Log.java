package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/20:52
 * @Description: 使用annotation的方式创建日志
 */
@Target(ElementType.METHOD) // 注解作用范围在方法上
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时存在
public @interface Log {
}
