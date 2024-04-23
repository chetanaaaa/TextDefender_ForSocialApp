package com.ooad.twitwit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ooad.twitwit.factory.SpamWordFactory;
import com.ooad.twitwit.model.SpamWord;
import com.ooad.twitwit.service.SpamWordService;

@Controller
@RequestMapping("/spam-words")
public class spamController {
    @Autowired
    private SpamWordService spamWordService;

    @Autowired
    private SpamWordFactory spamWordFactory;

    @PostMapping
    public String addSpamWord() {
        SpamWord spamWord = spamWordFactory.createSpamWord();
        spamWordService.addSpamWord(spamWord);
        return "filter";
    }

    @GetMapping
    public String getAllSpamWords() {
        List<SpamWord> spamWords = spamWordService.getAllSpamWords();
        return "filter";
    }

}
