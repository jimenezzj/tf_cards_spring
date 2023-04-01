package com.tfcards.tf_cards_spring.services.figures;

import com.tfcards.tf_cards_spring.commands.FigureCommand;
import com.tfcards.tf_cards_spring.converters.FigureCommandToFigure;
import com.tfcards.tf_cards_spring.converters.FigureToFigureCommand;
import com.tfcards.tf_cards_spring.domain.Figure;
import com.tfcards.tf_cards_spring.exceptions.NotFoundException;
import com.tfcards.tf_cards_spring.repositories.IFigureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class FigureServiceImpl implements IFiguresService {

    private final IFigureRepository figuresRepo;
    private final FigureCommandToFigure fgCmdConverter;
    private final FigureToFigureCommand fgConverter;

    public FigureServiceImpl(IFigureRepository figuresRepo, FigureCommandToFigure fgCmdConverter, FigureToFigureCommand fgConverter) {
        this.figuresRepo = figuresRepo;
        this.fgCmdConverter = fgCmdConverter;
        this.fgConverter = fgConverter;
    }

    @Override
    public Set<Figure> getFigures() {
        log.debug("I'm into figures service ---> Getting all figures");
        var figuresSet = new HashSet<Figure>();
        this.figuresRepo.findAll().forEach(figuresSet::add);
        return figuresSet;
    }

    @Override
    public Figure getById(Long id) {
        var foundFg = this.figuresRepo.findById(id);
        if (foundFg.isEmpty()) throw new NotFoundException("Figure was not found!");
        return foundFg.get();
    }

    @Override
    @Transactional
    public FigureCommand saveOrUpdateFigure(FigureCommand pFigure) {
        var detachFg = this.fgCmdConverter.convert(pFigure);
        var storeFg = this.figuresRepo.save(detachFg);
        log.debug("Figure entity stored into db");
        return this.fgConverter.convert(storeFg);
    }

    @Override
    public FigureCommand getByCommandId(Long id){
        var storeFg = this.getById(id);
        return this.fgConverter.convert(storeFg);
    }

}
