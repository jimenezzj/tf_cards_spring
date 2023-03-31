package com.tfcards.tf_cards_spring.domain;

import java.time.LocalDate;

public class UserTf {
    
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    
    public UserTf(Long pId, String name, String lastName, LocalDate birthDate) {
        this.id = pId;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    
}
