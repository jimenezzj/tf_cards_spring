package com.tfcards.tf_cards_spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int releaseYear;
    @Lob
    private String image;

    @Enumerated(EnumType.STRING)
    private EFigureSize size;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ItemNotes notes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FigureAccessory> accessories = new HashSet<>();

    @ManyToMany(mappedBy = "figures")
    private Set<FiguresCollector> figureCollectors;

    @ManyToOne
    private CollectionGroup collectGrp;

    public Figure() {
    }

    public Figure(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.collectGrp = null;
    }

    public void setNotes(ItemNotes notes) {
        this.notes = notes;
        notes.setFigure(this);
    }

    public void addAccessory(FigureAccessory newAccessory) {
        if (newAccessory == null) throw new RuntimeException("Accessory cannot be null");
        this.getAccessories().add(newAccessory);
        newAccessory.setFigure(this);
    }

}
