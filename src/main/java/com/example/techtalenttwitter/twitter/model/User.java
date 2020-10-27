package com.example.techtalenttwitter.twitter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

    @Id // Specifies primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Key automatically generated
    @Column(name = "user_id") // Changes the name in database
    private Long id;

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int active;

    @CreationTimestamp
    private Date createdAt;
}