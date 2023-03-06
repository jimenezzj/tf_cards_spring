package com.tfcards.tf_cards_spring.datasource;

public class FakeDataSource {

    private String user;
    private String password;
    private String jbcUrl;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJbcUrl() {
        return jbcUrl;
    }

    public void setJbcUrl(String jbcUrl) {
        this.jbcUrl = jbcUrl;
    }
}

