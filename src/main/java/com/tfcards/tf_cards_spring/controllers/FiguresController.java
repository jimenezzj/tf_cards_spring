package com.tfcards.tf_cards_spring.controllers;

import com.tfcards.tf_cards_spring.commands.FigureCommand;
import com.tfcards.tf_cards_spring.services.figures.IFiguresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(path = {"/{id}", "/show/{id}"})
    public String getFigure(@PathVariable String id, Model model) {
        var fgFound = this.figuresService.getById(Long.valueOf(id));
        model.addAttribute("figure", fgFound);
        return "figures/show";
    }

    @RequestMapping(path = "/new")
    public String getFgFormPage(Model model) {
        model.addAttribute("figure", new FigureCommand());
        model.addAttribute("yearsList", List.of(2017, 2018, 2019, 2020, 2021, 2022, 2023));
        return "figures/create";
    }

    @RequestMapping(path = {"/", "", "/save", "/new"}, method = RequestMethod.POST)
    public String createOrUpdateNewFigure(@ModelAttribute FigureCommand pFgCommand) {
        var savedFg = this.figuresService.saveOrUpdateFigure(pFgCommand);
        log.debug("Figure with id: %s was either saved or updated");
        return String.format("redirect:/figures/%1$d", savedFg.getId());
    }
    @RequestMapping(path = "/update/{id}")
    public String updateFgPage(@PathVariable("id") String pFgId, Model model) {
        var fgFound = this.figuresService.getByCommandId(Long.valueOf(pFgId));
        model.addAttribute("yearsList", List.of(2017, 2018, 2019, 2020, 2021, 2022, 2023));
        model.addAttribute("figure", fgFound);
        return "figures/create";
    }
}
