package com.ooad.twitwit.factory;

import org.springframework.stereotype.Component;

import com.ooad.twitwit.model.SpamWord;

@Component
public class SimpleSpamWordFactory implements SpamWordFactory {

    @Override
    public SpamWord createSpamWord() {
    	SpamWord spamWord = new SpamWord();
        // Initialize any properties of SpamWord here if needed
        spamWord.setWord("Default Word");
        return new SpamWord(); // You can customize the creation process as needed
    }
}
