package com.example.niceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.niceapi.model.ContactRequest;

@Repository
public interface ContactRepository extends JpaRepository<ContactRequest, Long> {

}
