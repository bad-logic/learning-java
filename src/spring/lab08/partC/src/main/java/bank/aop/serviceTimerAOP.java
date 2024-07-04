package bank.aop;

import bank.logging.ILogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;


@Aspect
@Configuration
public class serviceTimerAOP {

    @Autowired
    ILogger logger;

    public serviceTimerAOP(ILogger logger){
        this.logger = logger;
    }

    @Around("execution(public * bank.service.*.*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint jp) throws Throwable{
        StopWatch watch = new StopWatch();
        watch.start(jp.getSignature().getName());
        Object returnValue = jp.proceed(jp.getArgs());
        watch.stop();
        this.logger.log("Time Taken to execute "+ jp.getSignature().getName() + " = " + watch.getLastTaskTimeMillis() +"ms");
        return returnValue;
    }

}
