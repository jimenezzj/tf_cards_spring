package com.tfcards.tf_cards_spring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = {"figure"})
public class ItemNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @NonNul
    @Lob
    private String description;
    @OneToOne
    private Figure figure;

    public void setFigure(Figure figure) {
        this.figure = figure;
        if (figure.getNotes() == null) figure.setNotes(this);
    }

}