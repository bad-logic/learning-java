package com.example.lab.log.dto;

import java.time.Instant;
import java.util.UUID;

public class LoggerDTO {
    private UUID id;
    private Instant timestamp;
    private String operation;
    private String principle;

    public LoggerDTO(UUID id, Instant timestamp, String operation, String principle) {
        this.id = id;
        this.timestamp = timestamp;
        this.operation = operation;
        this.principle = principle;
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
}
