package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.FiguresCollectorCommand;
import com.tfcards.tf_cards_spring.domain.FiguresCollector;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FgCollectorCommandToFgCollector implements Converter<FiguresCollectorCommand, FiguresCollector> {

    private final FigureCommandToFigure fgConverter;

    public FgCollectorCommandToFgCollector(FigureCommandToFigure fgConverter) {
        this.fgConverter = fgConverter;
    }

    @Override
    public FiguresCollector convert(FiguresCollectorCommand source) {
        if (source == null) return null;
        var outCollector = new FiguresCollector();
        outCollector.setId(source.getId());
        outCollector.setTfCustomer(source.getTfCustomer());
        if (source.getFigures() != null && source.getFigures().size() > 0)
            outCollector.setFigures(
                    source.getFigures().stream()
                            .map(this.fgConverter::convert)
                            .collect(Collectors.toSet())
            );
        return outCollector;
    }

}
