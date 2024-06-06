package com.example.lab.exceptionLog;

import com.example.lab.common.CustomServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExceptionLogServiceImpl extends CustomServiceImpl<ExceptionLog, UUID> {

    public ExceptionLogServiceImpl(ExceptionLogRepository exceptionRepository) {
        super(exceptionRepository);
    }
}
