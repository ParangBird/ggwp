package com.backend.ggwp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private Integer profileIconId;
    private Long revisionDate;
    private Integer summonerLevel;
}
