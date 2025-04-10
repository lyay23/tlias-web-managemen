package com.itheima.aspect;

import com.itheima.anno.Log;
import com.itheima.entity.OperateLog;
import com.itheima.mapper.OperateLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Pointcut("execution(* com.itheima.controller.*.*(..))")
    public void controllerPointcut() {}

    @Around("controllerPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        // 获取方法参数
        String methodParams = Arrays.toString(joinPoint.getArgs());

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 获取返回值
        String returnValue = result == null ? "" : result.toString();

        // 计算方法执行耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        // 获取操作人ID，这里假设从ThreadLocal中获取
        Integer operateEmpId = getOperateEmpId();

        // 创建操作日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(operateEmpId);
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(className);
        operateLog.setMethodName(methodName);
        operateLog.setMethodParams(methodParams);
        operateLog.setReturnValue(returnValue);
        operateLog.setCostTime(costTime);

        // 保存操作日志
        operateLogMapper.insert(operateLog);

        return result;
    }

    private Integer getOperateEmpId() {
        // 这里假设从ThreadLocal中获取操作人ID
        // 实际项目中可能从Session或JWT中获取
        return 1; // 示例中返回1
    }
}