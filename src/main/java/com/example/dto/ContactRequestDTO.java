package com.example.dto;

import lombok.Getter;

@Getter
public class ContactRequestDTO {

    private String email;
    private String phoneNumber;

    // Getters and Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
