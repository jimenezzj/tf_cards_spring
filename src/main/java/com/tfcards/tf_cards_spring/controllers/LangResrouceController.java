package com.tfcards.tf_cards_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tfcards.tf_cards_spring.domain.LangMessage;
import com.tfcards.tf_cards_spring.services.FlirtPhraseGeneralService;

@RestController
public class LangResrouceController {

    private final FlirtPhraseGeneralService flirtPhrasesHandlr;

    public LangResrouceController(FlirtPhraseGeneralService flirtPhrasesHandlr) {
        this.flirtPhrasesHandlr = flirtPhrasesHandlr;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public String getWelcome() {
        return "Welcome to Language Resrouce Controller!";
    }

    @GetMapping("/flirt/random/{userName}")
    public LangMessage getRandomFlirtPhrase(@PathVariable String userName) {
        return new LangMessage(String.format("Hi %s!, %s", "Genesis", userName));
    }

}
