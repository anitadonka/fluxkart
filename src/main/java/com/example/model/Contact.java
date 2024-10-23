package com.example.model;

import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
public class Contact {
    public Long getId() {
        return Long.valueOf(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Change to Integer if you're using int in DB

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "linkedId")
    private Integer linkedId; // Change to Integer if you're using int in DB

    @Enumerated(EnumType.STRING)
    @Column(name = "linkPrecedence")
    private LinkPrecedence linkPrecedence; // Enum for 'primary' and 'secondary'

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @Column(name = "deletedAt")
    private Timestamp deletedAt;

    // Getters and Setters

    @ManyToOne
    @JoinColumn(name = "linkedId", referencedColumnName = "id", insertable = false, updatable = false)
    private Contact linkedContact;

    /**
     * get field @Column(name = "phoneNumber")
     *
     * @return phoneNumber @Column(name = "phoneNumber")

     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * set field @Column(name = "phoneNumber")
     *
     * @param phoneNumber @Column(name = "phoneNumber")

     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get field @Column(name = "email")
     *
     * @return email @Column(name = "email")

     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set field @Column(name = "email")
     *
     * @param email @Column(name = "email")

     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get field @Column(name = "linkedId")
     *
     * @return linkedId @Column(name = "linkedId")

     */
    public Integer getLinkedId() {
        return this.linkedId;
    }

    /**
     * set field @Column(name = "linkedId")
     *
     * @param linkedId @Column(name = "linkedId")

     */
    public void setLinkedId(Integer linkedId) {
        this.linkedId = linkedId;
    }

    /**
     * get field @Enumerated(EnumType.STRING)
     @Column(name = "linkPrecedence")

      *
      * @return linkPrecedence @Enumerated(EnumType.STRING)
     @Column(name = "linkPrecedence")

     */
    public LinkPrecedence getLinkPrecedence() {
        return this.linkPrecedence;
    }

    /**
     * set field @Enumerated(EnumType.STRING)
     @Column(name = "linkPrecedence")

      *
      * @param linkPrecedence @Enumerated(EnumType.STRING)
     @Column(name = "linkPrecedence")

     */
    public void setLinkPrecedence(LinkPrecedence linkPrecedence) {
        this.linkPrecedence = linkPrecedence;
    }

    /**
     * get field @Column(name = "createdAt")
     *
     * @return createdAt @Column(name = "createdAt")

     */
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    /**
     * set field @Column(name = "createdAt")
     *
     * @param createdAt @Column(name = "createdAt")

     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * get field @Column(name = "updatedAt")
     *
     * @return updatedAt @Column(name = "updatedAt")

     */
    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * set field @Column(name = "updatedAt")
     *
     * @param updatedAt @Column(name = "updatedAt")

     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * get field @Column(name = "deletedAt")
     *
     * @return deletedAt @Column(name = "deletedAt")

     */
    public Timestamp getDeletedAt() {
        return this.deletedAt;
    }

    /**
     * set field @Column(name = "deletedAt")
     *
     * @param deletedAt @Column(name = "deletedAt")

     */
    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * get field @ManyToOne
     @JoinColumn(name = "linkedId", referencedColumnName = "id", insertable = false, updatable = false)

      *
      * @return linkedContact @ManyToOne
     @JoinColumn(name = "linkedId", referencedColumnName = "id", insertable = false, updatable = false)

     */
    public Contact getLinkedContact() {
        return this.linkedContact;
    }

    /**
     * set field @ManyToOne
     @JoinColumn(name = "linkedId", referencedColumnName = "id", insertable = false, updatable = false)

      *
      * @param linkedContact @ManyToOne
     @JoinColumn(name = "linkedId", referencedColumnName = "id", insertable = false, updatable = false)

     */
    public void setLinkedContact(Contact linkedContact) {
        this.linkedContact = linkedContact;
    }
}
