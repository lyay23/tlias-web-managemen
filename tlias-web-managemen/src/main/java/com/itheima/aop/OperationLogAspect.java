package com.itheima.aop;

import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.util.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/04/10/20:59
 * @Description: 操作日志切面类，用于拦截控制器方法并记录操作日志。
 *               通过AOP（面向切面编程）实现对指定方法的环绕通知，记录方法执行的详细信息，
 *               包括方法名称、参数、返回值、执行耗时以及操作人ID，并将日志数据保存到数据库中。
 */
@Slf4j
@Aspect
@Component
public class OperationLogAspect {



    @Autowired
    private OperateLogMapper operateLogMapper;



    @Around("@annotation(com.itheima.anno.Log)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();



        // 执行目标方法
        Object result = joinPoint.proceed();


        // 计算方法执行耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;


        // 创建操作日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getOperateEmpId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setCostTime(costTime);
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result != null ? result.toString() : "void");

        // 保存操作日志
        log.info("操作日志：{}", operateLog);
        operateLogMapper.insert(operateLog);

        return result;
    }

    private Integer getOperateEmpId() {

        return CurrentHolder.getCurrentId();
    }




}