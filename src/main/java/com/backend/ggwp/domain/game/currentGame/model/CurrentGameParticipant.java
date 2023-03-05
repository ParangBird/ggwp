package com.backend.ggwp.domain.game.currentGame.model;

import com.backend.ggwp.domain.game.match.model.Perks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentGameParticipant {
    private Long championId;
    private Perks perks;
    private Long profileIconId;
    private boolean bot;
    private Long teamId;
    private String summonerName;
    private String summonerId;
    private Long spell1Id;
    private Long spell2Id;
    private List<GameCustomizationObject> gameCustomizationObjects;
}
