package com.backend.ggwp.domain.match;


import com.backend.ggwp.domain.match.Participant;
import com.backend.ggwp.domain.match.Team;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDto {
    public String summonerName;
    public Integer queueId;
    public List<Participant> participants;
    public List<Team> teams;
}
