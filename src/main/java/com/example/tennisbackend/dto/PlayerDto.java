package com.example.tennisbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private int id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    @JsonProperty("country")
    private CountryDto countryDto;
    private String picture;
    @JsonProperty("data")
    private PlayerDataDto playerDataDto;
}
