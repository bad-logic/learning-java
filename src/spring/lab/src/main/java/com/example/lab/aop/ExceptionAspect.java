package com.example.lab.aop;

import com.example.lab.exceptionLog.ExceptionLog;
import com.example.lab.exceptionLog.ExceptionLogServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class ExceptionAspect {

    private static final String PRINCIPLE = "user123";

    @Autowired
    ExceptionLogServiceImpl exceptionService;


    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerLayer() {
    }

    @AfterThrowing(pointcut = "controllerLayer()", throwing = "e")
    private void logException(JoinPoint joinPoint, Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        exceptionService.add(new ExceptionLog(joinPoint.getSignature().toString(), PRINCIPLE, e.getMessage(), sw.toString()));
    }

}
