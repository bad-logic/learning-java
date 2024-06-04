package com.example.lab.log;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;

    @CreatedDate
    private Instant timestamp;


    private String operation;
    private String principle;

    public Log() {
    }

    public Log(String operation, String principle) {
        this.operation = operation;
        this.principle = principle;
        this.timestamp = Instant.now();
    }

    public Log(UUID transactionId, Instant date, String operation, String principle) {
        this.transactionId = transactionId;
        this.timestamp = date;
        this.operation = operation;
        this.principle = principle;
    }


    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public void setTimestamp(Instant date) {
        this.timestamp = date;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getOperation() {
        return operation;
    }

    public String getPrinciple() {
        return principle;
    }
}
