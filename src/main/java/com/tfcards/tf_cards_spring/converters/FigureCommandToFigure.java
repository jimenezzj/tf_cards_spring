package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.FigureCommand;
import com.tfcards.tf_cards_spring.domain.Figure;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FigureCommandToFigure implements Converter<FigureCommand, Figure> {

    private final FigureAccessoryCommandToFigureAccessory fgAccessoryConverter;
    private final NotesCommandToNotes notesConverter;

    public FigureCommandToFigure(FigureAccessoryCommandToFigureAccessory pAccessoryConverter, NotesCommandToNotes notesConverter) {
        this.fgAccessoryConverter = pAccessoryConverter;
        this.notesConverter = notesConverter;
    }

    @Override
    @NonNull
    public Figure convert(FigureCommand source) {
        if (source == null) return null;
        Figure outFigure = new Figure(source.getName(), source.getReleaseYear());
        outFigure.setId(source.getId());
        outFigure.setNotes(this.notesConverter.convert(source.getNotes()));
        outFigure.setSize(source.getSize());
        outFigure.setCollectGrp(outFigure.getCollectGrp());
        if (source.getAccessories() != null && source.getAccessories().size() > 0) outFigure.setAccessories(
                source.getAccessories().stream()
                        .map(this.fgAccessoryConverter::convert)
                        .collect(Collectors.toSet())
        );
        if (source.getImage() != null) outFigure.setImage(this.convertMultiPartToByteArr(source.getImage()));
        return outFigure;
    }

    protected Byte[] convertMultiPartToByteArr(MultipartFile pMpFile) {
        Byte[] fileBytes = new Byte[0];
        try {
            fileBytes = new Byte[pMpFile.getBytes().length];
            int i = 0;
            for (byte b : pMpFile.getBytes()) {
                fileBytes[i++] = b;
            }
        } catch (IOException e) {
            //todo implement a better handling
            log.error("Error occurred while accessing image bytes", e);
            e.printStackTrace();
        }
        return fileBytes;
    }
}
