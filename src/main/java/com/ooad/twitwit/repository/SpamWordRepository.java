package com.ooad.twitwit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ooad.twitwit.model.SpamWord;

public interface SpamWordRepository extends JpaRepository<SpamWord, Long> {
    // Add custom methods if needed
	List<SpamWord> findAll();
}

