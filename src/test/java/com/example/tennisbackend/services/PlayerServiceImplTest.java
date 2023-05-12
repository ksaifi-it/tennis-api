package com.example.tennisbackend.services;

import com.example.tennisbackend.dataloader.DataLoader;
import com.example.tennisbackend.dto.PlayerDataDto;
import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.dto.StatsDto;
import com.example.tennisbackend.exceptions.PlayerNotFoundException;
import com.example.tennisbackend.fixtures.PlayerTestFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {

    @Mock
    private DataLoader dataLoader;

    @Mock
    private PlayerStatsCalculatorService playerStatsCalculatorService;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    void listPlayers_ShouldReturnSortedPlayerList() {
        // Given
        List<PlayerDto> expectedPlayerList = PlayerTestFixture.createPlayerDtoList();
        when(dataLoader.loadPlayers()).thenReturn(expectedPlayerList);

        // When
        List<PlayerDto> actualPlayerList = playerService.listPlayers();

        // Then
        assertThat(actualPlayerList)
                .isNotNull()
                .hasSize(4)
                .containsExactlyElementsOf(expectedPlayerList)
                .isSortedAccordingTo(Comparator.comparingInt((PlayerDto p) -> p.getPlayerDataDto().getRank()));
        // Verify
        verify(dataLoader, times(1)).loadPlayers();
    }

    @Test
    void getPlayer_WhenPlayerExists_ShouldReturnPlayerDto() {
        // Given
        List<PlayerDto> playerList = PlayerTestFixture.createPlayerDtoList();
        int playerId = 95;
        String playerFirstName = "VenusTest";
        when(dataLoader.loadPlayers()).thenReturn(playerList);

        // When
        PlayerDto actualPlayerDto = playerService.getPlayer(playerId);

        // Then
        assertThat(actualPlayerDto).isNotNull();
        assertThat(actualPlayerDto.getId()).isEqualTo(playerId);
        assertThat(actualPlayerDto.getFirstname()).isEqualTo(playerFirstName);

        // Verify
        verify(dataLoader, times(1)).loadPlayers();
    }

    @Test
    void getPlayer_WhenPlayerDoesNotExist_ShouldThrowPlayerNotFoundException() {
        // Given
        List<PlayerDto> playerList = PlayerTestFixture.createPlayerDtoList();
        int playerId = 99; // Non-existent player ID
        when(dataLoader.loadPlayers()).thenReturn(playerList);

        // When
        Throwable thrownException = catchThrowable(() -> playerService.getPlayer(playerId));

        // Then
        assertThat(thrownException)
                .isInstanceOf(PlayerNotFoundException.class)
                .hasMessage("Player with ID " + +playerId + " not found.");

        // Verify
        verify(dataLoader, times(1)).loadPlayers();
    }

    @Test
    void getPlayersStats_ShouldReturnStatsDto() {
        // Given
        List<PlayerDto> playerList = PlayerTestFixture.createPlayerDtoList();
        List<PlayerDataDto> playerData = PlayerTestFixture.createPlayerDataDtoList();
        double averageBMI = 12345.67;
        int medianHeight = 180;
        String countryWithHighestWinRatio = "USA";

        when(dataLoader.loadPlayers()).thenReturn(playerList);
        when(playerStatsCalculatorService.getAverageBMIOfPlayers(playerData)).thenReturn(averageBMI);
        when(playerStatsCalculatorService.getMedianHeightOfPlayers(playerData)).thenReturn(medianHeight);
        when(playerStatsCalculatorService.getCountryWithHighestWinRatio(playerList)).thenReturn(countryWithHighestWinRatio);

        // When
        StatsDto statsDto = playerService.getPlayersStats();

        // Then
        assertThat(statsDto).isNotNull();
        assertThat(statsDto.getAverageBMI()).isEqualTo(averageBMI);
        assertThat(statsDto.getMedianHeightOfPlayers()).isEqualTo(medianHeight);
        assertThat(statsDto.getCountryWithHighestWinRatio()).isEqualTo(countryWithHighestWinRatio);

        // Verify
        verify(dataLoader, times(1)).loadPlayers();
        verify(playerStatsCalculatorService, times(1)).getAverageBMIOfPlayers(playerData);
        verify(playerStatsCalculatorService, times(1)).getMedianHeightOfPlayers(playerData);
        verify(playerStatsCalculatorService, times(1)).getCountryWithHighestWinRatio(playerList);
    }

}