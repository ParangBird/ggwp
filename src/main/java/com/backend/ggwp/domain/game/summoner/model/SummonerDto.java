package com.backend.ggwp.domain.game.summoner.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class SummonerDto {
    private String id;
    private String name;
    private String profileIconUrl;
    private Integer summonerLevel;
    private SummonerLeagueInfo soloRank;
    private SummonerLeagueInfo flexRank;

    @Builder
    public SummonerDto(String id, String name, String profileIconUrl, Integer summonerLevel, SummonerLeagueInfo soloRank, SummonerLeagueInfo flexRank) {
        this.id = id;
        this.name = name;
        this.profileIconUrl = profileIconUrl;
        this.summonerLevel = summonerLevel;
        this.soloRank = soloRank;
        this.flexRank = flexRank;
    }
}