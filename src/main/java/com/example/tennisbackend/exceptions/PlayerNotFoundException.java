package com.example.tennisbackend.exceptions;

import org.springframework.http.HttpStatus;


public class PlayerNotFoundException extends ApiException {
    public PlayerNotFoundException(int playerId) {
        super(HttpStatus.NOT_FOUND, "Player with ID " + playerId + " not found.");
    }
}
