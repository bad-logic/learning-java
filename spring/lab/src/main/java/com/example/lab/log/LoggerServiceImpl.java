package com.example.lab.log;

import com.example.lab.common.CustomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoggerServiceImpl extends CustomServiceImpl<Log, UUID> {
    
    @Autowired
    public LoggerServiceImpl(LoggerRepository loggerRepository) {
        super(loggerRepository);
    }


}
