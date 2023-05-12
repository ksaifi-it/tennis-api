package com.example.tennisbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDataDto {
    private int rank;
    private int points;
    private int weight;
    private int height;
    private int age;
    private int[] last;
}
