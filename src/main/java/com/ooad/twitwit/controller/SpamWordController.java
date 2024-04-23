package com.ooad.twitwit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ooad.twitwit.factory.SpamWordFactory;
import com.ooad.twitwit.model.SpamWord;
import com.ooad.twitwit.service.SpamWordService;

@RestController
@RequestMapping("/api/spam-words")
public class SpamWordController {
    @Autowired
    private SpamWordService spamWordService;

    @Autowired
    private SpamWordFactory spamWordFactory;
    
    @GetMapping
    public ResponseEntity<List<SpamWord>> getAllSpamWords() {
        List<SpamWord> spamWords = spamWordService.getAllSpamWords();
        return ResponseEntity.ok(spamWords);
    }

    @PostMapping
    public ResponseEntity<?> addSpamWord(@RequestBody SpamWord spamWord) {
        spamWordService.addSpamWord(spamWord);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpamWord(@PathVariable Long id) {
        spamWordService.deleteSpamWord(id);
        return ResponseEntity.ok().build();
    }

    // Add other endpoints as needed
}

