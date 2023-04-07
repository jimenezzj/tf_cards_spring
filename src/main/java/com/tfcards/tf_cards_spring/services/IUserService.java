package com.tfcards.tf_cards_spring.services;

import java.util.Optional;
import java.util.Set;

import com.tfcards.tf_cards_spring.domain.UserTf;

public interface IUserService {

    Set<UserTf> getAll();

    UserTf getUser(Long id);

    UserTf save(UserTf newUser);

    boolean removeById(String id);

}
