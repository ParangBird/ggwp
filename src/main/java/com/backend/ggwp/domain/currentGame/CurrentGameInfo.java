package com.backend.ggwp.domain.currentGame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentGameInfo {
    private Long gameId;
    private String gameType;
    private Long gameStartTime;
    private Long mapId;
    private Long gameLength;
    private String platformId;
    private String gameMode;
    private List<BannedChampion> bannedChampions;
    private Long gameQueueConfigId;
    private Observer observers;
    private List<CurrentGameParticipant> participants;
}
