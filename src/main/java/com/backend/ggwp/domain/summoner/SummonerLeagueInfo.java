package com.backend.ggwp.domain.summoner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SummonerLeagueInfo {
        private String leagueId;
        private String queueType;
        private String tier;
        private String rank;
        private String summonerId;
        private String summonerName;
        private Integer leaguePoints;
        private Integer wins;
        private Integer losses;
        private Boolean veteran;
        private Boolean inactive;
        private Boolean freshBlood;
        private Boolean hotStreak;
}
