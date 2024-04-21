package com.ooad.twitwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooad.twitwit.model.SpamWord;
import com.ooad.twitwit.repository.SpamWordRepository;

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
