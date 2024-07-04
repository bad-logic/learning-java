package com.example.lab.aop;

import com.example.lab.log.Log;
import com.example.lab.log.LoggerServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final String PRINCIPLE = "user123";

    @Autowired
    LoggerServiceImpl loggerService;

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controllerLayer() {
    }

    @AfterReturning(pointcut = "controllerLayer()", returning = "result")
    private void logOperation(JoinPoint joinPoint, Object result) {
        loggerService.add(new Log(joinPoint.getSignature().toString(), PRINCIPLE));
    }
}
