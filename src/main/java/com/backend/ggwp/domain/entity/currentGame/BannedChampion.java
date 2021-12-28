package com.backend.ggwp.domain.entity.currentGame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BannedChampion {
    private Integer pickTurn;
    private Long championId;
    private Long teamId;
}
