package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.FigureCommand;
import com.tfcards.tf_cards_spring.domain.Figure;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FigureToFigureCommand implements Converter<Figure, FigureCommand> {

    private final FigureAccessoryToFigureaccessoryCommand accessoryConverter;
    private final NotesToNotesCommand noteConverter;

    public FigureToFigureCommand(FigureAccessoryToFigureaccessoryCommand accessoryConverter, NotesToNotesCommand noteConverter) {
        this.accessoryConverter = accessoryConverter;
        this.noteConverter = noteConverter;
    }

    @Override
    @NonNull
    public FigureCommand convert(Figure source) {
        if (source == null) return null;
        var outFgCmd = new FigureCommand();
        outFgCmd.setId(source.getId());
        outFgCmd.setName(source.getName());
        outFgCmd.setNotes(this.noteConverter.convert(source.getNotes()));
        outFgCmd.setSize(source.getSize());
        outFgCmd.setReleaseYear(source.getReleaseYear());
        if (source.getAccessories() != null && source.getAccessories().size() > 0)
            outFgCmd.setAccessories(
                    source.getAccessories().stream().map(this.accessoryConverter::convert).collect(Collectors.toSet())
            );
        outFgCmd.setImageByteArr(source.getImage());
        return outFgCmd;
    }

}
