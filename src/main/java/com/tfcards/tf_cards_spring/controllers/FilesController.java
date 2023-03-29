package com.tfcards.tf_cards_spring.controllers;

import com.tfcards.tf_cards_spring.services.figures.IFiguresService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FilesController {

    private final IFiguresService figuresService;
    public FilesController(IFiguresService figuresService) {
        this.figuresService = figuresService;
    }

}
