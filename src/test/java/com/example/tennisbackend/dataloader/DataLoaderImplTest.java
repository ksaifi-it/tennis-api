package com.example.tennisbackend.dataloader;


import com.example.tennisbackend.dto.PlayerDto;
import com.example.tennisbackend.exceptions.InternalServerErrorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DataLoaderImplTest {

    @Mock
    private Resource resource;

    @InjectMocks
    private DataLoaderImpl dataLoader;

    @Test
    void loadPlayers_ShouldReturnListOfPlayers() throws IOException {
        // Given
        InputStream inputStream = new ClassPathResource("players.json").getInputStream();

        // When
        List<PlayerDto> playersList = dataLoader.loadPlayers();

        // Then
        assertThat(playersList).isNotNull();
        assertThat(playersList).hasSizeGreaterThan(0);
    }



}

