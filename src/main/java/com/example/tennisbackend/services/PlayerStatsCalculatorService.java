package com.example.tennisbackend.services;

import com.example.tennisbackend.dto.PlayerDataDto;
import com.example.tennisbackend.dto.PlayerDto;

import java.util.List;

public interface PlayerStatsCalculatorService {
    String getCountryWithHighestWinRatio(List<PlayerDto> playerList);
    double getAverageBMIOfPlayers(List<PlayerDataDto> playerDataList);
    int getMedianHeightOfPlayers(List<PlayerDataDto> playerDataList);
}
