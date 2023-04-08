package com.tfcards.tf_cards_spring.commands;

import com.tfcards.tf_cards_spring.domain.Figure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class FigureAccessoryCommand {
    private Long id;
    private String name;
    private BigDecimal cost;
    private Figure figure;
    private String description;

}
