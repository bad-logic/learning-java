package com.example.partB.aop;

import com.example.partB.integrations.EmailSender;
import com.example.partB.integrations.IEmailSender;
import com.example.partB.integrations.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Aspect
@Configuration
public class EmailSenderAOP {
    private ILogger logger;

    @Autowired
    public EmailSenderAOP(ILogger logger){
        this.logger = logger;
    }

    @After("execution(public void com.example.partB.integrations.IEmailSender.sendEmail(String,String))")
    public void log(JoinPoint jp) {
        List<Object> args = Arrays.stream(jp.getArgs()).toList();
        IEmailSender domain = (EmailSender) jp.getTarget();
        System.out.println(LocalDateTime.now()+" method="+jp.getSignature().getName()+" address="+ args.get(0) + " message="+ args.get(1)+ " outgoing mail server="+domain.getOutgoingMailServer());
    }
}
