package com.tfcards.tf_cards_spring.repositories;

import com.tfcards.tf_cards_spring.domain.CollectionGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface ICollectionGroupRepo extends CrudRepository<CollectionGroup, Long> {
    Set<CollectionGroup> findCollectionGroupByReleaseYearIn(Collection<Integer> years);

    Optional<CollectionGroup> findByNameContaining(String infix);
}
