package com.backend.ggwp.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Summoner {
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
