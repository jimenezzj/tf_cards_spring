package com.tfcards.tf_cards_spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "collection_groups")
@Getter
@Setter
public class CollectionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;        
    private int releaseYear;

    @OneToMany
    @JoinColumn(name = "collect_grp_id")
    private Set<Figure> figures = new HashSet<>();

    public CollectionGroup() {
    }

    public CollectionGroup(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        setFigures(new HashSet<>());
    }
}
