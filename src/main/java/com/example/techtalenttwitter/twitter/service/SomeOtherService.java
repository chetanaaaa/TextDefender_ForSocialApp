package com.example.techtalenttwitter.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.techtalenttwitter.twitter.model.SpamWord;

@Service
public class SomeOtherService {

    @Autowired
    private SpamWordService spamWordService;

    public void someMethod() {
        // Use the SpamWordService instance to call the getAllSpamWords method
        List<SpamWord> spamWords = spamWordService.getAllSpamWords();
        // Do something with the spamWords...
    }
}

