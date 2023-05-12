package com.example.tennisbackend.services;

import com.example.tennisbackend.dto.CountryDto;
import com.example.tennisbackend.dto.PlayerDataDto;
import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.fixtures.PlayerTestFixture;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class PlayerStatsCalculatorServiceImplTest {
    private PlayerStatsCalculatorServiceImpl calculator = new PlayerStatsCalculatorServiceImpl();

    @Test
    void getCountryWithHighestWinRatio_ShouldReturnCountryWithHighestWinRatio() {
        // Given

        List<PlayerDto> playerList = PlayerTestFixture.createPlayerDtoList();

        // When
        String countryWithHighestWinRatio = calculator.getCountryWithHighestWinRatio(playerList);

        // Then
        assertThat(countryWithHighestWinRatio).isEqualTo("SRB");
    }

    @Test
    void getMedianHeightOfPlayers_ShouldReturnMedianHeight() {
        // Given
        List<PlayerDataDto> playerDataList =  PlayerTestFixture.createPlayerDataDtoList();

        // When
        int medianHeight = calculator.getMedianHeightOfPlayers(playerDataList);

        // Then
        assertThat(medianHeight).isEqualTo(185);
    }

    @Test
    void getAverageBMIOfPlayers_ShouldReturnAverageBMI() {
        // Given
        List<PlayerDataDto> playerDataList =  PlayerTestFixture.createPlayerDataDtoList();

        // When
        double averageBMI = calculator.getAverageBMIOfPlayers(playerDataList);

        // Then
        assertThat(averageBMI).isEqualTo(23.15);
    }

}
