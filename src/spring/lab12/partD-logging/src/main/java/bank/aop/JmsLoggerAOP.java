package bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class JmsLoggerAOP {
    Logger logger = LoggerFactory.getLogger(JmsLoggerAOP.class);

    @After("execution(public * bank.jms.JMSSender.*(String))")
    public void logMessages(JoinPoint jp){
        this.logger.info("JMS MESSAGE :{}", jp.getArgs()[0]);
    }



}
