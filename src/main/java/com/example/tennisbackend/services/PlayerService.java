package com.example.tennisbackend.services;

import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.dto.StatsDto;

import java.io.IOException;
import java.util.List;

public interface PlayerService {
    List<PlayerDto> listPlayers();

    PlayerDto getPlayer(int id);
    StatsDto getPlayersStats();
}
