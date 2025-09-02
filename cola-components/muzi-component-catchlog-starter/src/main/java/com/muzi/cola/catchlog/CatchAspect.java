package com.muzi.cola.catchlog;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
@Slf4j
public class CatchAspect {


    @Pointcut("@within(com.muzi.cola.catchlog.CatchLog) && execution(public * *(..))")
    public void catchPointcut() {

    }

    @Around(value = "catchPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object[] args = joinPoint.getArgs();

        Object res = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        log.info("{}.{}.args: {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), JSON.toJSONString(args));
        log.info("result: {}, cost: {} ms", JSON.toJSONString(res), endTime - startTime);
        return res;
    }
}
