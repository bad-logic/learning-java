package com.example.lab.exceptionLog.dto;

import java.time.Instant;
import java.util.UUID;

public class ExceptionLogDTO {
    private UUID id;
    private Instant timestamp;
    private String operation;
    private String principle;
    private String exceptionType;
    private String stackTrace;

    public ExceptionLogDTO(UUID id, Instant timestamp, String operation, String principle, String exceptionType, String stackTrace) {
        this.id = id;
        this.timestamp = timestamp;
        this.operation = operation;
        this.principle = principle;
        this.exceptionType = exceptionType;
        this.stackTrace = stackTrace;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }
}
