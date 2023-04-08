package com.tfcards.tf_cards_spring.converters;

import com.tfcards.tf_cards_spring.commands.ItemNotesCommand;
import com.tfcards.tf_cards_spring.domain.ItemNotes;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<ItemNotesCommand, ItemNotes> {

    @Override
    @NonNull
    public ItemNotes convert(ItemNotesCommand source) {
        if (source == null) return null;
        var outNotes = new ItemNotes();
        outNotes.setId(source.getId());
        outNotes.setDescription(source.getDesc());
        return outNotes;
    }
}
