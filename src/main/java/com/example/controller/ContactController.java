package com.example.controller;


    import com.example.dto.ContactRequestDTO;
    import com.example.dto.ContactResponseDTO;
    import com.example.model.Contact;
    import org.springframework.beans.factory.annotation.Autowired;

    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import com.example.service.ContactService;

    @RestController
    @RequestMapping("/identify")
    public class ContactController {

        @Autowired
        private ContactService contactService;




        @PostMapping("/test")
        public ResponseEntity<ContactResponseDTO> identify(@RequestBody ContactRequestDTO contact){
            Contact con = new Contact();
            con.setEmail(contact.getEmail());
            con.setPhoneNumber(contact.getPhoneNumber());
                // Call the service to identify and consolidate contacts
                ContactResponseDTO response = contactService.identifyContact(con);

                // Return the response entity with HTTP status 200
                return ResponseEntity.ok(response);

            }
        @GetMapping("/tests")
        public ResponseEntity<String> testEndpoint() {
            return ResponseEntity.ok("Test endpoint is working");
        }
        @GetMapping("/ping")
        public ResponseEntity<String> ping() {
            return ResponseEntity.ok("pong");
        }
        }



