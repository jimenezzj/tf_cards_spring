package com.tfcards.tf_cards_spring.services;

import org.springframework.stereotype.Service;

@Service("FlirstPhreaseHandlr")
public class FlirtPhraseGeneralService {

    private final IFlirtPhraseService flirtService;

    // public FlirtPhraseGeneralService() {
    public FlirtPhraseGeneralService(IFlirtPhraseService pFlirtPhraseService) {
        this.flirtService = pFlirtPhraseService;
    }

    public String getRandPickupLine() {
        return this.flirtService.getRandFlirtPhrase();
    }

}
