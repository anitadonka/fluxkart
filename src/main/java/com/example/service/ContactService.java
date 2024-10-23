package com.example.service;

import java.util.*;

import com.example.dto.ContactRequestDTO;
import com.example.dto.ContactResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Contact;
import com.example.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactResponseDTO identifyContact(Contact request) {
        // Logic to identify and consolidate contacts based on the request
        // Assume we are retrieving contacts based on email or phone number

        // Query the database to find matching contacts
        contactRepository.save(request);

        String email = request.getEmail();
        String phoneNumber = request.getPhoneNumber();
        List<Contact> contacts = contactRepository.findByEmailOrPhoneNumber(email, phoneNumber);

        // Consolidate contacts (marking primary and secondary contacts)
        ContactResponseDTO response = new ContactResponseDTO();

        // Process contacts and populate response DTO
        // Example: Assume the first contact is the primary one
        Contact primaryContact = null;
        if (!contacts.isEmpty()) {
             primaryContact = contacts.get(0);
            response.setPrimaryContactId(primaryContact.getId());
        }



        List<String> emails = new ArrayList<>();
        List<String> phoneNumbers = new ArrayList<>();
        List<Long> secondaryContactIds = new ArrayList<>();

        // Add primary contact details
        emails.add(primaryContact.getEmail());
        phoneNumbers.add(primaryContact.getPhoneNumber());

        // Add secondary contacts
        for (int i = 1; i < contacts.size(); i++) {
            Contact secondary = contacts.get(i);
            secondaryContactIds.add(secondary.getId());

            if (secondary.getEmail() != null && !emails.contains(secondary.getEmail())) {
                emails.add(secondary.getEmail());
            }
            if (secondary.getPhoneNumber() != null && !phoneNumbers.contains(secondary.getPhoneNumber())) {
                phoneNumbers.add(secondary.getPhoneNumber());
            }
        }

        response.setEmails(emails);
        response.setPhoneNumbers(phoneNumbers);
        response.setSecondaryContactIds(secondaryContactIds);

        return response;
    }
    public ContactResponseDTO getContactById(Long id) {
        Optional<Contact> contactOpt = contactRepository.findById(id);

        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();

            ContactResponseDTO response = new ContactResponseDTO();
            response.setPrimaryContactId(contact.getId());
            response.setEmails(Arrays.asList(contact.getEmail()));
            response.setPhoneNumbers(Arrays.asList(contact.getPhoneNumber()));
            response.setSecondaryContactIds(new ArrayList<>()); // Populate secondary contacts if necessary

            return response;
        } else {
            return null; // Contact not found
        }
    }

}
