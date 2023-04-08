package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.FigureAccessoryCommand;
import com.tfcards.tf_cards_spring.domain.FigureAccessory;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component

public class FigureAccessoryCommandToFigureAccessory implements Converter<FigureAccessoryCommand, FigureAccessory> {

    @Override
    @NonNull
    public FigureAccessory convert(FigureAccessoryCommand source) {
        if (source == null) return null;
        var outAccessory = new FigureAccessory(source.getName(), source.getDescription(), source.getCost());
        outAccessory.setId(source.getId());
        outAccessory.setFigure(source.getFigure());
        return outAccessory;
    }
}
