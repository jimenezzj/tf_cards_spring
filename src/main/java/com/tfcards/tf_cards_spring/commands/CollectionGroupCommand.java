package com.tfcards.tf_cards_spring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CollectionGroupCommand {
    private long id;

    private String name;
    private int releaseYear;
}
