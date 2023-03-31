package com.tfcards.tf_cards_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfcards.tf_cards_spring.domain.UserTf;
import com.tfcards.tf_cards_spring.services.IUserService;

@RestController
@RequestMapping(path = "/user")
public class UserResourceController {

    private final IUserService userService;

    public UserResourceController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public UserTf getUser(@PathVariable String id) {
        var foundUser = this.userService.getUser(Long.valueOf(id));
        return foundUser;
    }
}
