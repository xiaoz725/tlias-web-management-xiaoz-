package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.OperateLogMapper;
import org.example.pojo.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(org.example.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        OperateLog oLog = new OperateLog();
        oLog.setOperateEmpId(getCurrentUserId());
        oLog.setOperateTime(LocalDateTime.now());
        oLog.setClassName(joinPoint.getTarget().getClass().getName());
        oLog.setMethodName(joinPoint.getSignature().getName());
        oLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        // 防止返回值null触发空指针
        oLog.setReturnValue(result == null ? "null" : result.toString());
        oLog.setCostTime(costTime);

        log.info("记录操作日志：{}",oLog);
        operateLogMapper.insert(oLog);
        return result;
    }

    private int getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
