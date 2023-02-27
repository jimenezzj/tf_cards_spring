package com.tfcards.tf_cards_spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Primary
@Profile("ENG")
@Service("FlirtPhraseServImpl")
public class FlirtPhraseEngService implements IFlirtPhraseService {

    protected List<String> phrases = new ArrayList<>(List.of(
            "Has anyone ever told you that you look like Drew Barrymore?",
            "Are you Wifi? Cuz we can have a greate connection!",
            "Would you like something to drink?",
            "When can I see you again? Pick a day that ends in \"y\"",
            "Do you believe in love at first text? Because you can delete this one, and I can keep texting until you do"));

    @Override
    public String getRandFlirtPhrase() {
        var randPhrase = phrases.get(
            new Random().nextInt(0, this.phrases.size())    
        );
        return randPhrase;
    }

}
