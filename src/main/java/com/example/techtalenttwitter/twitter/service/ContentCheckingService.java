package com.example.techtalenttwitter.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.techtalenttwitter.twitter.model.SpamWord;

@Service
public class ContentCheckingService {
    @Autowired
    private SpamWordService spamWordService;

    public boolean containsSpamWord(String content) {
        List<SpamWord> spamWords = spamWordService.getAllSpamWords();
        for (SpamWord spamWord : spamWords) {
            if (content.contains(spamWord.getWord())) {
                return true;
            }
        }
        return false;
    }
}

