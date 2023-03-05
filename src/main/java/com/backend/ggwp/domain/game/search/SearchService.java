package com.backend.ggwp.domain.game.search;

import com.backend.ggwp.domain.game.summoner.SummonerService;
import com.backend.ggwp.domain.game.summoner.model.AccountInfo;
import com.backend.ggwp.domain.game.summoner.model.SummonerDTO;
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

    public SummonerDTO search(String summonerName) {
        AccountInfo accountInfo = summonerService.getAccountInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = summonerService.getAllSummonerLeagueInfo(accountInfo.getId());
        SummonerDTO summonerDto = summonerService.getSummonerDto(accountInfo, leagueInfos, API_INFO);
        return summonerDto;
    }
}
