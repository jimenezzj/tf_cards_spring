package com.tfcards.tf_cards_spring.commands;

import java.time.LocalDateTime;
import java.util.Set;

public class ApiErrorDetails {

    private String msg;
    private Set<String> errors;
    private LocalDateTime timestamp;
    
    public ApiErrorDetails(String msg, Set<String> errors, LocalDateTime timestamp) {
        super();
        this.msg = msg;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Set<String> getErrors() {
        return errors;
    }

    public void setErrors(Set<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
