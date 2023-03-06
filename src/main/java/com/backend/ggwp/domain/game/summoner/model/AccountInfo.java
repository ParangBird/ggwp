package com.backend.ggwp.domain.game.summoner.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountInfo {
    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private Integer profileIconId;
    private Long revisionDate;
    private Integer summonerLevel;
}