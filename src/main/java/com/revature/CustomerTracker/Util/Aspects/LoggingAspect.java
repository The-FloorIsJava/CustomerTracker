package com.revature.CustomerTracker.Util.Aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger();

    @Pointcut("within(com.revature..*)")
    public void pcLogAll(){}

    @Before("pcLogAll()")
    public void logMethodStart(JoinPoint joinPoint){
        String methodArguments = Arrays.toString(joinPoint.getArgs());
        logger.info("{} was successfully invoked at {} with the provided arguments: {}", extractClassMethodSignature(joinPoint), LocalDateTime.now(), methodArguments);
    }

    @AfterReturning(pointcut = "pcLogAll()", returning = "returnedObject")
    public void logMethodReturn(JoinPoint joinPoint, Object returnedObject) {
        logger.info("{} successfully returned at {} with value: {} ", extractClassMethodSignature(joinPoint), LocalDateTime.now(), returnedObject);
    }

    @AfterThrowing(pointcut = "pcLogAll()", throwing = "t")
    public void logMethodThrowable(JoinPoint joinPoint, Throwable t){
        String throwableName = t.getClass().getName();
        logger.warn("{} was thrown in {} at {} with message: {}", throwableName, extractClassMethodSignature(joinPoint), LocalDateTime.now(), t.getMessage());
    }

    private String extractClassMethodSignature(JoinPoint joinPoint){
        return joinPoint.getTarget().getClass().toString() + "#" + joinPoint.getSignature().getName();
    }

}
