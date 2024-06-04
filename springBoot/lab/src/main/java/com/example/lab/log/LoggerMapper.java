package com.example.lab.log;


import com.example.lab.log.dto.LoggerDTO;

public class LoggerMapper {

    LoggerDTO toLoggerDTO(Log log) {
        if (log == null) return null;
        return new LoggerDTO(log.getTransactionId(), log.getTimestamp(), log.getOperation(), log.getPrinciple());
    }
}
