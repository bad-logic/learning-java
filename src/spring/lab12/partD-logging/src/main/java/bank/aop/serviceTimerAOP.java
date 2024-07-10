package bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;


@Aspect
@Configuration
public class serviceTimerAOP {

    Logger logger = LoggerFactory.getLogger(serviceTimerAOP.class);


    @Around("execution(public * bank.service.*.*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint jp) throws Throwable{
        StopWatch watch = new StopWatch();
        watch.start(jp.getSignature().getName());
        Object returnValue = jp.proceed(jp.getArgs());
        watch.stop();
        this.logger.info("Time Taken to execute {} = {}ms", jp.getSignature().getName(), watch.getLastTaskTimeMillis());
        return returnValue;
    }

}
