package com.example.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ContactResponseDTO {

    private Long primaryContactId;
    private List<String> emails;
    private List<String> phoneNumbers;
    private List<Long> secondaryContactIds;

    // Getters and Setters

    public void setPrimaryContactId(Long primaryContactId) {
        this.primaryContactId = primaryContactId;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setSecondaryContactIds(List<Long> secondaryContactIds) {
        this.secondaryContactIds = secondaryContactIds;
    }
}

