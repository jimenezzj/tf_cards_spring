package com.tfcards.tf_cards_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfcards.tf_cards_spring.repositories.IFigureRepository;

@Controller
public class FiguresController {

    private IFigureRepository figuresRepo;

    public FiguresController(IFigureRepository pIFigureRepository) {
        this.figuresRepo = pIFigureRepository;
    }

    @RequestMapping(path = "/figures")
    public String getFigures(Model model) {

        var figuresSet = this.figuresRepo.findAll();
        System.out.println(figuresSet);
        model.addAttribute("figures", figuresSet);

        return "figures/list";
    }
}
