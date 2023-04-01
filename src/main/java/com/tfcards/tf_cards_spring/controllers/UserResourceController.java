package com.tfcards.tf_cards_spring.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping(path = { "/", "" })
    public ResponseEntity<UserTf> createUser(@RequestBody UserTf newUser) {
        var storedUser = this.userService.save(newUser);
        URI crrLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(storedUser.getId())
                .toUri();
        return ResponseEntity.created(crrLocation).build();
        // return null;
    }
}
