package com.tfcards.tf_cards_spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "collection_groups")
public class CollectionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<Figure> getFigures() {
        return figures;
    }

    public void setFigures(Set<Figure> figures) {
        this.figures = figures;
    }
}
