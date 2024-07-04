package bank.aop;


import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DaoLoggerAOP {
    @Autowired
    ILogger logger;

    public DaoLoggerAOP(ILogger logger){
        this.logger = logger;
    }

    // (visibility returnType package.sub_package.class.method(args))
    @Before("execution(public * bank.dao.*.*(..))")
    public void logMethodCall(JoinPoint jp){
        this.logger.log("calling method " + jp.getSignature().getName());
    }
}
