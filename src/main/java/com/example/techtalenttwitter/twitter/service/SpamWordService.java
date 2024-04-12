package com.example.techtalenttwitter.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.techtalenttwitter.twitter.model.SpamWord;
import com.example.techtalenttwitter.twitter.repository.SpamWordRepository;

@Service
public class SpamWordService {
    @Autowired
    private SpamWordRepository spamWordRepository;

    public List<SpamWord> getAllSpamWords() {
        return spamWordRepository.findAll();
    }

    public void addSpamWord(SpamWord spamWord) {
        spamWordRepository.save(spamWord);
    }

    public void deleteSpamWord(Long id) {
        spamWordRepository.deleteById(id);
    }

    // Add other methods as needed
}
