package com.example.partB.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class DaoAOP {

    @Around("within(@org.springframework.stereotype.Repository *)")
    public Object calculateExecutionTime(ProceedingJoinPoint jp) throws Throwable{
        StopWatch watch = new StopWatch();
        watch.start(jp.getSignature().getName());
        Object returnValue = jp.proceed();
        watch.stop();
        System.out.println("Time Taken to execute "+ jp.getSignature().getName() + " = " + watch.getLastTaskTimeMillis() +"ms");
        return returnValue;
    }

}
