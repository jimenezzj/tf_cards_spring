package com.tfcards.tf_cards_spring.controllers;

import com.tfcards.tf_cards_spring.services.lang.IQuotePhrasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfcards.tf_cards_spring.services.FlirtPhraseGeneralService;
import com.tfcards.tf_cards_spring.services.IFlirtPhraseService;

@RequestMapping("/lang")
@Controller
public class LangController {

    private final ApplicationContext springCtx;
    private IQuotePhrasesService quotePhrasesService;

    // public LangController(IFlirtPhraseService pFlirtPhraseService) {
    public LangController(ApplicationContext pSpringCtx) {
        this.springCtx = pSpringCtx;
    }

    @RequestMapping("/flirt-phrase")
    public String getFlirtPhrase(Model model) {
        FlirtPhraseGeneralService flirttHandlr = (FlirtPhraseGeneralService) springCtx.getBean("FlirstPhreaseHandlr");
        model.addAttribute("pickupLine", flirttHandlr.getRandPickupLine());
        return "lang/flirt_phrase";
    }

    @RequestMapping("/quotes")
    public String getQuotePhrase(Model mdl) {
        var quotesLIst = this.quotePhrasesService.getAll();
        mdl.addAttribute("quotesList", quotesLIst);
        System.out.println(quotesLIst);
        return "quote/list";
    }

    @Autowired
    public void setQuotePhrasesService(IQuotePhrasesService quotePhrasesService) {
        this.quotePhrasesService = quotePhrasesService;

    }
}
