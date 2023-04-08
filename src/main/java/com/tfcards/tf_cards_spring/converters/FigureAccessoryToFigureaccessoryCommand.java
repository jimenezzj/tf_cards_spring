package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.FigureAccessoryCommand;
import com.tfcards.tf_cards_spring.domain.FigureAccessory;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component

public class FigureAccessoryToFigureaccessoryCommand implements Converter<FigureAccessory, FigureAccessoryCommand> {

    @NonNull
    @Override
    public FigureAccessoryCommand convert(FigureAccessory source) {
        if (source == null) return null;
        var outAccessory = new FigureAccessoryCommand();
        outAccessory.setId(source.getId());
        outAccessory.setName(source.getName());
        outAccessory.setCost(source.getCost());
        outAccessory.setDescription(source.getDescription());
        outAccessory.setFigure(source.getFigure());
        return outAccessory;

    }
}
