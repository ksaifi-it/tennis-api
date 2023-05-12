package com.example.tennisbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsDto {
    double averageBMI;
    int medianHeightOfPlayers;
    String countryWithHighestWinRatio;
}
