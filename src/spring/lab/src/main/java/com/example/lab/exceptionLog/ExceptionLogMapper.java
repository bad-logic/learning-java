package com.example.lab.exceptionLog;

import com.example.lab.exceptionLog.dto.ExceptionLogDTO;

public class ExceptionLogMapper {

    ExceptionLogDTO toExceptionLogDTO(ExceptionLog ex) {
        if (ex == null) return null;
        return new ExceptionLogDTO(ex.getTransactionId(), ex.getTimestamp(), ex.getOperation(), ex.getPrinciple(), ex.getType(), ex.getStackTrace());
    }

}
