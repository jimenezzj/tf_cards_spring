package com.tfcards.tf_cards_spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tfcards.tf_cards_spring.domain.Figure;

public interface FigureRepository extends CrudRepository<Figure, Long>{
    
}
