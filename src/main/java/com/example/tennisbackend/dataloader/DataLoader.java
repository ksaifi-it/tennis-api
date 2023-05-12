package com.example.tennisbackend.dataloader;

import com.example.tennisbackend.dto.PlayerDto;

import java.util.List;

public interface DataLoader {
    List<PlayerDto> loadPlayers();
}
