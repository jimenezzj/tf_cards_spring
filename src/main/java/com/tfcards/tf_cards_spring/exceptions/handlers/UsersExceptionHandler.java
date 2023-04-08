package com.tfcards.tf_cards_spring.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tfcards.tf_cards_spring.commands.ApiErrorDetails;
import com.tfcards.tf_cards_spring.exceptions.UserNotFoundException;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorDetails> handleUserNotFound(UserNotFoundException ex) {
        var defaultErrMsg = "User with given id was not found";
        var err = new ApiErrorDetails(Optional.of(ex.getMessage()).orElse(defaultErrMsg), null, LocalDateTime.now());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

}
