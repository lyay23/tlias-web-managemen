package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/06/20:44
 * @Description: 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handlerException(Exception e) {
         // 1.记录日志
        log.error("系统异常", e);
        // 2.返回错误信息
        return Result.error("我有错，都是我的错");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        /*
        报错信息演示：
           ### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'liyang' for key 'emp.username';
            Duplicate entry 'liyang' for key 'emp.username'
         */

        log.error("数据库中已存在该记录", e);
        // e.getMessage() 获取到异常信息
        String message = e.getMessage();
        // 从Duplicate entry向后截取
        int duplicateEntry = message.indexOf("Duplicate entry");
        String errMsg=message.substring(duplicateEntry);
        // 分割字符串
        String[] split = errMsg.split(" ");
        // 返回错误信息 第3个元素
        return Result.error("数据库中已存在该记录"+split[2]);
    }
}
