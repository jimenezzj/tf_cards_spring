package com.tfcards.tf_cards_spring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "collection_groups")
@Data
public class CollectionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;        
    private int releaseYear;

    @OneToMany
    @JoinColumn(name = "collect_grp_id")
    private Set<Figure> figures;

    public CollectionGroup() {
    }

    public CollectionGroup(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        setFigures(new HashSet<>());
    }
}
