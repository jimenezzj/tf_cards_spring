package com.tfcards.tf_cards_spring.domain;

public class LangMessage {
    
    private String message;

    public LangMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LangMessage [message=" + message + "]";
    }
    
}
