package com.example.tennisbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerIntTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getPlayer_ShouldReturnPlayerDto() throws Exception {
        // Given
        int playerId = 17;
        String expectedJson = "{\"id\": 17,\"firstname\": \"RafaelTest\",\"lastname\": \"Nadal\",\"shortname\": \"R.NAD\",\"sex\": \"M\",\"picture\": \"https://Nadal.png\",\"country\": {\"picture\": \"https://Espagne.png\",\"code\": \"ESP\"},\"data\": {\"rank\": 1,\"points\": 1982,\"weight\": 85000,\"height\": 185,\"age\": 33,\"last\": [1, 0, 0, 0, 1]}}";

        // When
        mockMvc.perform(get("/api/players/{id}", playerId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));
    }

    @Test
    void allPlayers_ShouldReturnListOfPlayerDtos() throws Exception {
        // Given
        String expectedJson = "[" +
                "{\"id\": 17,\"firstname\": \"RafaelTest\",\"lastname\": \"Nadal\",\"shortname\": \"R.NAD\",\"sex\": \"M\",\"picture\": \"https://Nadal.png\",\"country\": {\"picture\": \"https://Espagne.png\",\"code\": \"ESP\"},\"data\": {\"rank\": 1,\"points\": 1982,\"weight\": 85000,\"height\": 185,\"age\": 33,\"last\": [1, 0, 0, 0, 1]}},"
                + "{\"id\": 52,\"firstname\": \"NovakTest\",\"lastname\": \"Djokovic\",\"shortname\": \"N.DJO\",\"sex\": \"M\",\"picture\": \"https://Djokovic.png\",\"country\": {\"picture\": \"https://Serbie.png\",\"code\": \"SRB\"},\"data\": {\"rank\": 2,\"points\": 2542,\"weight\": 80000,\"height\": 188,\"age\": 31,\"last\": [1, 1, 1, 1, 1]}},"
                + "{\"id\": 102,\"firstname\": \"SerenaTest\",\"lastname\": \"Williams\",\"shortname\": \"S.WIL\",\"sex\": \"F\",\"picture\": \"https://Serena.png\",\"country\": {\"picture\": \"https://USA.png\",\"code\": \"USA\"},\"data\": {\"rank\": 10,\"points\": 3521,\"weight\": 72000,\"height\": 175,\"age\": 37,\"last\": [0, 1, 1, 1, 0]}},"
                + "{\"id\": 65,\"firstname\": \"StanTest\",\"lastname\": \"Wawrinka\",\"shortname\": \"S.WAW\",\"sex\": \"M\",\"picture\": \"https://Wawrinka.png\",\"country\": {\"picture\": \"https://Suisse.png\",\"code\": \"SUI\"},\"data\": {\"rank\": 21,\"points\": 1784,\"weight\": 81000,\"height\": 183,\"age\": 33,\"last\": [1, 1, 1, 0, 1]}},"
                + "{\"id\": 95,\"firstname\": \"VenusTest\",\"lastname\": \"Williams\",\"shortname\": \"V.WIL\",\"sex\": \"F\",\"picture\": \"https://Venus.webp\",\"country\": {\"picture\": \"https://USA.png\",\"code\": \"USA\"},\"data\": {\"rank\": 52,\"points\": 1105,\"weight\": 74000,\"height\": 185,\"age\": 38,\"last\": [0, 1, 0, 0, 1]}}" +
                "]";
        // When
        mockMvc.perform(get("/api/players"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));

    }

    @Test
    void allPlayersStats_ShouldReturnStatsDto() throws Exception {
        {
            // Given
            String expectedJson = "{\"averageBMI\": 23.36, \"medianHeightOfPlayers\": 185, \"countryWithHighestWinRatio\": \"SRB\"}";

            // When
            mockMvc.perform(get("/api/players/stats"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(expectedJson));
        }
    }
}