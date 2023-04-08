package com.tfcards.tf_cards_spring.commands;

import com.tfcards.tf_cards_spring.domain.Figure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class FiguresCollectorCommand {
    private Long id;
    private String tfCustomer;
    private Set<FigureCommand> figures = new HashSet<>();

}
