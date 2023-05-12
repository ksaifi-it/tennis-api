package com.example.tennisbackend.wrappers;

import com.example.tennisbackend.dto.PlayerDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlayerListWrapper {
    @JsonProperty("players")
    private List<PlayerDto> playerDtoList;

}
