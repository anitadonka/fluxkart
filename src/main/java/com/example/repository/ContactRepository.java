package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByEmailOrPhoneNumber(String email, String phoneNumber);

    // Additional methods for querying contacts...
    List<Contact> findByLinkedContact(Contact linkedContact);

    // Optional: Find all contacts by phone number alone
    List<Contact> findByPhoneNumber(String phoneNumber);

    // Optional: Find all contacts by email alone
    List<Contact> findByEmail(String email);
}
