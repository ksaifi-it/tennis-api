package com.example.tennisbackend.controller;

import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.dto.StatsDto;
import com.example.tennisbackend.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @Operation(summary = "Get player by Id", description = "Retrieve a player by ID.")
    @GetMapping(path = "/{id}")
    public PlayerDto getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }
    @Operation(summary = "Get players", description = "Retrieve the list of players.")
    @GetMapping()
    public List<PlayerDto> allPlayers() throws IOException {
        return playerService.listPlayers();
    }

    @Operation(summary = "Get players stats", description = "Give stats about players.")
    @GetMapping(path = "/stats")
    public StatsDto allPlayersStats() throws IOException {
        return playerService.getPlayersStats();
    }
}