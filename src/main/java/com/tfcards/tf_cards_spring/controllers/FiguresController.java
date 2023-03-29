package com.tfcards.tf_cards_spring.controllers;

import com.tfcards.tf_cards_spring.commands.FigureCommand;
import com.tfcards.tf_cards_spring.services.figures.IFiguresService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        var fgFound = this.figuresService.getByCommandId(Long.valueOf(id));
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

    @RequestMapping(path = "/image/{id}")
    public void getImage(@PathVariable("id") String imgId, @RequestParam String mimeType, HttpServletResponse servletResponse) throws IOException {
        String contentType = "";
        var fgFound = this.figuresService.getByCommandId(Long.valueOf(imgId));
        if (fgFound == null) throw new RuntimeException("Invalid image id provided");
        contentType = switch (mimeType.toLowerCase()) {
            case "jpg" -> MediaType.IMAGE_JPEG_VALUE;
            case "png" -> MediaType.IMAGE_PNG_VALUE;
            default -> throw new RuntimeException("Invalid MIME type request for image");
        };
        byte[] byteArray = new byte[fgFound.getImageByteArr().length];
        int i = 0;
        for (Byte wrappedByte : fgFound.getImageByteArr()) {
            byteArray[i++] = wrappedByte; //auto unboxing
        }
        InputStream in = new ByteArrayInputStream(byteArray);
        servletResponse.setContentType(contentType);
        IOUtils.copy(in, servletResponse.getOutputStream());
    }

}
