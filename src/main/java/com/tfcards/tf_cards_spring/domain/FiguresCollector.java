package com.tfcards.tf_cards_spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "figures_collectors")
public class FiguresCollector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tfCustomer;

    @ManyToMany
    @JoinTable(
        name = "figures_fcollector", 
        joinColumns = @JoinColumn(name = "figures_collectors_id"), 
        inverseJoinColumns = @JoinColumn(name = "figure_id")
    )
    private Set<Figure> figures;

    public FiguresCollector() {
    }

    public FiguresCollector(String tfCustomer) {
        this.tfCustomer = tfCustomer;
        setFigures(new HashSet<>());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        FiguresCollector other = (FiguresCollector) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTfCustomer() {
        return tfCustomer;
    }

    public void setTfCustomer(String user) {
        this.tfCustomer = user;
    }

    public Set<Figure> getFigures() {
        return figures;
    }

    private void setFigures(Set<Figure> figures) {
        this.figures = figures;
    }

}
