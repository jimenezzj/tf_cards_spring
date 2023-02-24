package com.tfcards.tf_cards_spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Figure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private CollectionGroup collectGrp;
    
    private int releaseYear;

    @ManyToMany(mappedBy = "figures")
    private Set<FiguresCollector> figureCollectors;

    public Figure() {
    }

    public Figure(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.figureCollectors = new HashSet<>();
        this.collectGrp = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Figure other = (Figure) obj;
        if (id != other.id)
            return false;
        return true;
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

    public CollectionGroup getCollectGrp() {
        return collectGrp;
    }

    public void setCollectGrp(CollectionGroup collectGrp) {
        this.collectGrp = collectGrp;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<FiguresCollector> getFigureCollectors() {
        return figureCollectors;
    }

    public void setFigureCollectors(Set<FiguresCollector> figureCollectors) {
        this.figureCollectors = figureCollectors;
    }

}
