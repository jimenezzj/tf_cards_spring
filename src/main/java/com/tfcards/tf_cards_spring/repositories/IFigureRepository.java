package com.tfcards.tf_cards_spring.repositories;

import com.tfcards.tf_cards_spring.domain.EFigureSize;
import org.springframework.data.repository.CrudRepository;

import com.tfcards.tf_cards_spring.domain.Figure;

import java.util.Collection;
import java.util.Set;

public interface IFigureRepository extends CrudRepository<Figure, Long> {
    Set<Figure> findByReleaseYearIn(Collection<Integer> years);

    Set<Figure> findByNameContaining(String nameLike);

    Set<Figure> findBySizeEquals(EFigureSize size);
}
