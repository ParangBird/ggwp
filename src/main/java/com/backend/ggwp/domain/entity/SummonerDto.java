package com.backend.ggwp.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SummonerDto {
    private String id;
    private String name;
    private String profileIconUrl;
    private Integer summonerLevel;
}