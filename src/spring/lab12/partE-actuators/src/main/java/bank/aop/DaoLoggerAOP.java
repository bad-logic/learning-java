package bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DaoLoggerAOP {
    Logger logger = LoggerFactory.getLogger(DaoLoggerAOP.class);

    // (visibility returnType package.sub_package.class.method(args))
    @Before("execution(public * bank.repository.*.*(..))")
    public void logMethodCall(JoinPoint jp){
        this.logger.info("calling method {}", jp.getSignature().getName());
    }
}
