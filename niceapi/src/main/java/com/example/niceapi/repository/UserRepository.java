package com.example.niceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.niceapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
