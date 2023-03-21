package com.tfcards.tf_cards_spring.controllers;

import com.tfcards.tf_cards_spring.services.figures.IFiguresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/figures")
@Slf4j
public class FiguresController {

    private IFiguresService figuresService;

    public FiguresController(IFiguresService pIFigureRepository) {
        this.figuresService = pIFigureRepository;
    }

    @RequestMapping(path = {"", "/", "/list"})
    public String getFigures(Model model) {
        var figuresSet = this.figuresService.getFigures();
//        System.out.println(figuresSet);
        log.debug("Figures fetched: ", figuresSet);
        model.addAttribute("figures", figuresSet);
        return "figures/list";
    }
}
