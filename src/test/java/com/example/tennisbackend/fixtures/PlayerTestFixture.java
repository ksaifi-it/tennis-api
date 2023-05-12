package com.example.tennisbackend.fixtures;

import com.example.tennisbackend.dto.CountryDto;
import com.example.tennisbackend.dto.PlayerDataDto;
import com.example.tennisbackend.dto.PlayerDto;

import java.util.Arrays;
import java.util.List;

public class PlayerTestFixture {
    public static List<PlayerDto> createPlayerDtoList() {
        CountryDto countryDto1 = new CountryDto("https://Serbie.png", "SRB");
        PlayerDataDto playerDataDto1 = new PlayerDataDto(2, 2542, 80000, 188, 31, new int[]{1, 1, 1, 1, 1});
        PlayerDto playerDto1 = new PlayerDto(52, "NovakTest", "Djokovic", "N.DJO", "M", countryDto1, "https://Djokovic.png", playerDataDto1);

        CountryDto countryDto2 = new CountryDto("https://USA.png", "USA");
        PlayerDataDto playerDataDto2 = new PlayerDataDto(52, 1105, 74000, 185, 38, new int[]{0, 1, 0, 0, 1});
        PlayerDto playerDto2 = new PlayerDto(95, "VenusTest", "Williams", "V.WIL", "F", countryDto2, "https://Venus.webp", playerDataDto2);

        CountryDto countryDto3 = new CountryDto("https://Espagne.png", "ESP");
        PlayerDataDto playerDataDto3 = new PlayerDataDto(1, 1982, 85000, 185, 33, new int[]{1, 0, 0, 0, 1});
        PlayerDto playerDto3 = new PlayerDto(17, "RafaelTest", "Nadal", "R.NAD", "M", countryDto3, "https://Nadal.png", playerDataDto3);

        CountryDto countryDto4 = new CountryDto("https://USA.png", "USA");
        PlayerDataDto playerDataDto4 = new PlayerDataDto(10, 3521, 72000, 175, 37, new int[]{0, 1, 1, 1, 0});
        PlayerDto playerDto4 = new PlayerDto(102, "SerenaTest", "Williams", "S.WIL", "F", countryDto4, "https://Serena.png", playerDataDto4);

        return Arrays.asList(playerDto1, playerDto2, playerDto3,playerDto4);
    }
    public static List<PlayerDataDto> createPlayerDataDtoList(){
       return PlayerTestFixture.createPlayerDtoList().stream().map(PlayerDto::getPlayerDataDto).toList();
    }

}
