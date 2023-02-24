package com.tfcards.tf_cards_spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tfcards.tf_cards_spring.domain.CollectionGroup;

public interface ICollectionGroupRepo extends CrudRepository<CollectionGroup, Long> {

}
