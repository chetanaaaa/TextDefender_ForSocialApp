package com.example.techtalenttwitter.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techtalenttwitter.twitter.model.SpamWord;

public interface SpamWordRepository extends JpaRepository<SpamWord, Long> {
    // Add custom methods if needed
	List<SpamWord> findAll();
}

