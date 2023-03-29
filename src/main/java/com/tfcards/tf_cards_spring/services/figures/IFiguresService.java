package com.tfcards.tf_cards_spring.services.figures;

import com.tfcards.tf_cards_spring.commands.FigureCommand;
import com.tfcards.tf_cards_spring.domain.Figure;

import java.util.Set;

public interface IFiguresService {

    Set<Figure> getFigures();

    Figure getById(Long id);

    FigureCommand saveOrUpdateFigure(FigureCommand pFigure);

    FigureCommand getByCommandId(Long id);
}
