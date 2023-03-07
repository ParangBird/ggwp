package com.backend.ggwp.domain.game.search;

import com.backend.ggwp.domain.game.summoner.SummonerService;
import com.backend.ggwp.domain.game.summoner.model.SummonerInfo;
import com.backend.ggwp.domain.game.summoner.model.SummonerInfoDTO;
import com.backend.ggwp.domain.game.summoner.model.SummonerLeagueInfo;
import com.backend.ggwp.utils.ApiInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchService {

    private final ApiInfo API_INFO;
    private final SummonerService summonerService;

    public SummonerInfoDTO search(String summonerName) {
        SummonerInfo summonerInfo = summonerService.getSummonerInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = summonerService.getAllSummonerLeagueInfo(summonerInfo.getId());
        SummonerInfoDTO summonerInfoDto = summonerService.getSummonerInfoDTO(summonerInfo, leagueInfos, API_INFO);
        return summonerInfoDto;
    }
}
