package com.tfcards.tf_cards_spring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ItemNotesCommand {
    private Long id;
    private String desc;
}
