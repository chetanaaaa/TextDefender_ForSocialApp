package com.example.techtalenttwitter.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techtalenttwitter.twitter.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
