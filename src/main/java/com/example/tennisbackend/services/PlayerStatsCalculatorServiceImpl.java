package com.example.tennisbackend.services;

import com.example.tennisbackend.dto.PlayerDataDto;
import com.example.tennisbackend.dto.PlayerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class PlayerStatsCalculatorServiceImpl implements PlayerStatsCalculatorService {

    @Override
    public String getCountryWithHighestWinRatio(List<PlayerDto> playerList) {
        Map<String, Long> countryWinsMap = playerList.stream()
                .collect(Collectors.groupingBy(
                        player -> player.getCountryDto().getCode(),
                        Collectors.summingLong(player -> player.getPlayerDataDto().getLast()[0])
                ));

        return countryWinsMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public int getMedianHeightOfPlayers(List<PlayerDataDto> playerDataList) {

        int playerCount = playerDataList.size();
        if (playerCount == 0) {
            return 0; // Return 0 if there are no players
        }

        List<Integer> heights = playerDataList.stream()
                .map(PlayerDataDto::getHeight)
                .sorted().toList();

        int middleIndex = playerCount / 2;
        return playerCount % 2 == 0 ? (heights.get(middleIndex - 1) + heights.get(middleIndex)) / 2 : heights.get(middleIndex);
    }

    @Override
    public double getAverageBMIOfPlayers(List<PlayerDataDto> playerDataList) {
        double sumBMI = playerDataList.stream()
                .mapToDouble(playerData -> calculateBMI(playerData.getWeight(), playerData.getHeight()))
                .sum();

        int playerCount = playerDataList.size();
        if (playerCount == 0) {
            return 0.0;
        }
        double averageBmiResult = sumBMI / playerCount;
       return Math.round(averageBmiResult * 100.0) / 100.0;
    }

    private double calculateBMI(int weightGrams, int height) {
        double weightKg = weightGrams / 1000.0; // Convert grams to kilograms
        double heightInMeters = height / 100.0;
        return weightKg / (heightInMeters * heightInMeters);
    }
}
