package com.tfcards.tf_cards_spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tfcards.tf_cards_spring.domain.CollectionGroup;

import java.util.Collection;
import java.util.Set;

public interface ICollectionGroupRepo extends CrudRepository<CollectionGroup, Long> {
    Set<CollectionGroup> findCollectionGroupByReleaseYearIn(Collection<Integer> years);
}
