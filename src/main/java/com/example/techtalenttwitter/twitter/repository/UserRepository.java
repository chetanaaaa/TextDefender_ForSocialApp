package com.example.techtalenttwitter.twitter.repository;

import com.example.techtalenttwitter.twitter.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
