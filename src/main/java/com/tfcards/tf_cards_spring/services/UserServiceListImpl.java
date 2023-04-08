package com.tfcards.tf_cards_spring.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.tfcards.tf_cards_spring.domain.UserTf;
import com.tfcards.tf_cards_spring.exceptions.UserNotFoundException;

@Service
public class UserServiceListImpl implements IUserService {

    private static Set<UserTf> usersList = new HashSet<>();
    private static Long listSize = Long.valueOf(usersList.size());

    static {
        usersList.add(new UserTf(++listSize, "Sam", "Witwicky", LocalDate.now().minusYears(35)));
        usersList.add(new UserTf(++listSize, "Mikaela", "Banes", LocalDate.now().minusYears(32)));
        usersList.add(new UserTf(++listSize, "William", "Lenox", LocalDate.now().minusYears(45)));
        usersList.add(new UserTf(++listSize, "Seymour", "Simmons", LocalDate.now().minusYears(52)));
    }

    @Override
    public UserTf getUser(Long id) {
        Predicate<? super UserTf> findById = user -> user.getId() == id;
        var foundUser = usersList.stream().filter(findById).findFirst();
        if (!foundUser.isPresent())
            throw new UserNotFoundException(String.format("User with id: %d was not found!", id));
        return foundUser.get();
    }

    @Override
    public UserTf save(UserTf newUser) {
        newUser.setId(++listSize);
        // TODO: this can be improved
        if (!usersList.add(newUser))
            throw new RuntimeException("Something went wrong while trying to save the user;");
        return newUser;
    }

    @Override
    public Set<UserTf> getAll() {
        return usersList;
    }

    @Override
    public boolean removeById(String id) {
        Boolean isRemoved = usersList.removeIf(u -> u.getId().equals(Long.valueOf(id)));
        if (!isRemoved)
            throw new UserNotFoundException(String.format("There\'s no user with the given id (%s)", id));
        return isRemoved;
    }

}
