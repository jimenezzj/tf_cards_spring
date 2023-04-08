package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.ItemNotesCommand;
import com.tfcards.tf_cards_spring.domain.ItemNotes;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<ItemNotes, ItemNotesCommand> {

    @Override
    @NonNull
    public ItemNotesCommand convert(ItemNotes source) {
        if (source == null) return null;
        var outItemNotes = new ItemNotesCommand();
        outItemNotes.setId(source.getId());
        outItemNotes.setDesc(source.getDescription());
        return outItemNotes;
    }
}
