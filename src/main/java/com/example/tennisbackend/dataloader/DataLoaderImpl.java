package com.example.tennisbackend.dataloader;

import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.exceptions.InternalServerErrorException;
import com.example.tennisbackend.wrappers.PlayerListWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoaderImpl implements DataLoader{

    private static final String INPUT_FILE = "players.json";

    public List<PlayerDto> loadPlayers() {
        List<PlayerDto> playersList = new ArrayList<>();
        Resource resource = new ClassPathResource(INPUT_FILE);

        // Validate resource existence
        if (!resource.exists()) {
            throw new InternalServerErrorException("Input file not found: " + INPUT_FILE);
        }

        try (InputStream inputStream = resource.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            PlayerListWrapper wrapper = objectMapper.readValue(inputStream, PlayerListWrapper.class);
            playersList = wrapper.getPlayerDtoList();
        } catch (JsonProcessingException e) {
            throw new InternalServerErrorException("Error processing JSON: " + e.getMessage());
        } catch (IOException e) {
            throw new InternalServerErrorException("Error reading file"+ e.getMessage());
        }

        return playersList;
    }

    }
