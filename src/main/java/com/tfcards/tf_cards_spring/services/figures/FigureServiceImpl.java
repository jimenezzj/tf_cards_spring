package com.tfcards.tf_cards_spring.services.figures;

import com.tfcards.tf_cards_spring.domain.Figure;
import com.tfcards.tf_cards_spring.repositories.IFigureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class FigureServiceImpl implements IFiguresService {

    private final IFigureRepository figuresRepo;

    public FigureServiceImpl(IFigureRepository figuresRepo) {
        this.figuresRepo = figuresRepo;
    }

    @Override
    public Set<Figure> getFigures() {
        log.debug("I'm into figures service ---> Getting all figures");
        var figuresSet = new HashSet<Figure>();
        this.figuresRepo.findAll().forEach(figuresSet::add);
        return figuresSet;
    }
}
