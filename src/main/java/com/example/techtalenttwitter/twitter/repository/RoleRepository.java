package com.example.techtalenttwitter.twitter.repository;

import com.example.techtalenttwitter.twitter.model.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
