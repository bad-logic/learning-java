package bank.aop;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class JmsLoggerAOP {
    @Autowired
    ILogger logger;
    public JmsLoggerAOP(ILogger logger){
        this.logger = logger;
    }

    @After("execution(public * bank.jms.JMSSender.*(String))")
    public void logMessages(JoinPoint jp){
        this.logger.log("JMS MESSAGE :" + jp.getArgs()[0]);
    }



}
