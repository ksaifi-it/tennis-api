package com.example.tennisbackend.services;

import com.example.tennisbackend.dataloader.DataLoader;
import com.example.tennisbackend.dto.PlayerDataDto;
import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.dto.StatsDto;
import com.example.tennisbackend.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private DataLoader dataLoader;
    private PlayerStatsCalculatorService playerStatsCalculatorService;

    public PlayerServiceImpl(DataLoader dataLoader, PlayerStatsCalculatorService playerStatsCalculatorService) {
        this.dataLoader = dataLoader;
        this.playerStatsCalculatorService = playerStatsCalculatorService;
    }

    @Override
    public List<PlayerDto> listPlayers() {
        List<PlayerDto> playerList = dataLoader.loadPlayers();
        playerList.sort(Comparator.comparingInt((PlayerDto p) -> p.getPlayerDataDto().getRank()));
        return playerList;
    }

    @Override
    public PlayerDto getPlayer(int id) {
        List<PlayerDto> playerList = dataLoader.loadPlayers();
        Optional<PlayerDto> playerOptional = playerList.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
        return playerOptional.orElseThrow(() -> new PlayerNotFoundException(id));
    }
    @Override
    public StatsDto getPlayersStats() {
        List<PlayerDto> playerList = dataLoader.loadPlayers();
        List<PlayerDataDto> playerData = playerList.stream().map(PlayerDto::getPlayerDataDto).toList();

        double averageBMIOfPlayers = playerStatsCalculatorService.getAverageBMIOfPlayers(playerData);
        int medianHeightOfPlayers = playerStatsCalculatorService.getMedianHeightOfPlayers(playerData);
        String countryWithHighestWinRatio = playerStatsCalculatorService.getCountryWithHighestWinRatio(playerList);

        return new StatsDto(averageBMIOfPlayers,medianHeightOfPlayers,countryWithHighestWinRatio);
    }

}


