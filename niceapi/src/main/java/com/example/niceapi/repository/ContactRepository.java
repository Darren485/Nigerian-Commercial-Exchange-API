package com.example.niceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.niceapi.model.ContactRequest;

public interface ContactRepository extends JpaRepository<ContactRequest, Long> {

}
