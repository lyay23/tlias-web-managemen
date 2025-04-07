package com.itheima.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/07/20:19
 * @Description: 自定义业务异常（继承RuntimeException避免强制try-catch）
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}