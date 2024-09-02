package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.models;

import java.time.LocalDateTime;

public class CustomError {

    private String message;
    private int status;
    private LocalDateTime date;
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
