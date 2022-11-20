package com.backend.ggwp.restapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RotationInfo {
    private List<Integer> freeChampionIds = null;
    private List<Integer> freeChampionIdsForNewPlayers = null;
    private Integer maxNewPlayerLevel;
}
