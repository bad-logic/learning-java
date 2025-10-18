package com.example.spring.security.controllers;

public class ErrorResponseDTO {
    private String msg;

    public ErrorResponseDTO(String msg) {
        this.msg = msg;
    }

    public ErrorResponseDTO() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
