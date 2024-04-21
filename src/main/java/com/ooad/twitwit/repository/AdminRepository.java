package com.ooad.twitwit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ooad.twitwit.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
