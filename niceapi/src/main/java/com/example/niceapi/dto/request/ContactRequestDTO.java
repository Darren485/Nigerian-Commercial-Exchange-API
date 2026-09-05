package com.example.niceapi.dto.request;

import com.example.niceapi.model.Category;
import com.example.niceapi.model.ContactStatus;
import com.example.niceapi.model.Sector;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactRequestDTO {
    @NotNull(message = " Contact ID is required")
    private Long id;

    @NotBlank(message = " Full name is required")
    private String fullName;

    @NotBlank(message = " Email is required")
    private String email;

    @NotBlank(message = " Phone number is required")
    private String phoneNumber;

    @NotBlank(message = " Subject is required")
    private String subject;

    @NotBlank(message = " Message is required")
    private String message;

    @NotNull(message = " Sector is required")
    private Sector sector;

    @NotNull(message = " Category is required")
    private Category category;

    @NotNull(message = " Status is required")
    private ContactStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ContactStatus getStatus() {
        return status;
    }

    public void setStatus(ContactStatus status) {
        this.status = status;
    }
}
