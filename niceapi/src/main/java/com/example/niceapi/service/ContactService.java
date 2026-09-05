package com.example.niceapi.service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.niceapi.dto.request.ContactRequestDTO;
import com.example.niceapi.dto.response.ContactResponseDTO;
import com.example.niceapi.model.ContactRequest;
import com.example.niceapi.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactResponseDTO> getAllContact() {
        return contactRepository.findAll().stream()
                .map(contact -> new ContactResponseDTO(
                        contact.getId(),
                        contact.getFullName(),
                        contact.getEmail(),
                        contact.getPhoneNumber(),
                        contact.getSubject(),
                        contact.getMessage(),
                        contact.getStatus(),
                        contact.getCategory(),
                        contact.getSector()))
                .collect(Collectors.toList());
    }

    public Optional<ContactResponseDTO> getContactById(Long id) {
        ContactRequest request = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
        return Optional.of(new ContactResponseDTO(
                request.getId(),
                request.getFullName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getSubject(),
                request.getMessage(),
                request.getStatus(),
                request.getCategory(),
                request.getSector()));
    }

    public ContactResponseDTO sumbitComplaint(ContactRequestDTO request) {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setFullName(request.getFullName());
        contactRequest.setEmail(request.getEmail());
        contactRequest.setPhoneNumber(request.getPhoneNumber());
        contactRequest.setSubject(request.getSubject());
        contactRequest.setMessage(request.getMessage());
        contactRequest.setStatus(request.getStatus());
        contactRequest.setCategory(request.getCategory());
        contactRequest.setSector(request.getSector());
        contactRepository.save(contactRequest);
        return new ContactResponseDTO(
                contactRequest.getId(),
                contactRequest.getFullName(),
                contactRequest.getEmail(),
                contactRequest.getPhoneNumber(),
                contactRequest.getSubject(),
                contactRequest.getMessage(),
                contactRequest.getStatus(),
                contactRequest.getCategory(),
                contactRequest.getSector());
    }

    public void deleteComplaint(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contact not found with id: " + id);
        }
        contactRepository.deleteById(id);
    }
}
