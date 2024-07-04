package com.example.lab.exceptionLog;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@Entity
public class ExceptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;

    @CreatedDate
    private Instant timestamp;


    private String operation;
    private String principle;

    @Column(columnDefinition = "text")
    private String stackTrace;

    private String type;

    public ExceptionLog() {
    }

    public ExceptionLog(String operation, String principle, String exceptionType, String stackTrace) {
        this.operation = operation;
        this.principle = principle;
        this.type = exceptionType;
        this.stackTrace = stackTrace;
        this.timestamp = Instant.now();
    }

    public ExceptionLog(UUID transactionId, Instant timestamp, String operation, String principle, String exceptionType, String stackTrace) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.operation = operation;
        this.principle = principle;
        this.type = exceptionType;
        this.stackTrace = stackTrace;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
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

    public String getType() {
        return type;
    }

    public void setType(String exceptionType) {
        this.type = exceptionType;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

}
