package com.backend.ggwp.domain.game.search;

import com.backend.ggwp.domain.game.summoner.summonerinfo.SummonerInfo;
import com.backend.ggwp.domain.game.summoner.summonerinfo.SummonerInfoDto;
import com.backend.ggwp.domain.game.summoner.summonerinfo.SummonerInfoService;
import com.backend.ggwp.domain.game.summoner.summonerleagueinfo.SummonerLeagueInfo;
import com.backend.ggwp.domain.game.summoner.summonerleagueinfo.SummonerLeagueInfoService;
import com.backend.ggwp.utils.ApiInfo;
import com.backend.ggwp.utils.StringFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchService {

    private final ApiInfo API_INFO;
    private final SummonerInfoService summonerInfoService;
    private final SummonerLeagueInfoService summonerLeagueInfoService;

    public SummonerInfoDto search(String summonerName) {
        summonerName = StringFormat.setApiString(summonerName);
        SummonerInfo summonerInfo = summonerInfoService.getSummonerInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = summonerLeagueInfoService.getAllSummonerLeagueInfo(summonerInfo.getSummonerId());
        SummonerInfoDto summonerInfoDto = summonerInfoService.getSummonerInfoDTO(summonerInfo, leagueInfos, API_INFO);
        return summonerInfoDto;
    }
}
