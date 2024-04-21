package com.example.techtalenttwitter.twitter.factory;

import org.springframework.stereotype.Component;

import com.example.techtalenttwitter.twitter.model.SpamWord;

@Component
public class SimpleSpamWordFactory implements SpamWordFactory {

    @Override
    public SpamWord createSpamWord() {
        return new SpamWord(); // You can customize the creation process as needed
    }
}
