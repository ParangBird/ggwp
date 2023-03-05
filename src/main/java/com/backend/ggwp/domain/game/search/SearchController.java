package com.backend.ggwp.domain.game.search;

import com.backend.ggwp.domain.game.summoner.SummonerService;
import com.backend.ggwp.domain.game.summoner.model.AccountInfo;
import com.backend.ggwp.domain.game.summoner.model.SummonerDto;
import com.backend.ggwp.domain.game.summoner.model.SummonerLeagueInfo;
import com.backend.ggwp.utils.ApiInfo;
import com.backend.ggwp.utils.StringFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final ApiInfo API_INFO;
    private final SearchService searchService;
    private final SummonerService summonerService;

    @GetMapping("/reactSearch/{name}")
    public SummonerDto index(@PathVariable(value = "name") String name) {
        String summonerName = StringFormat.setApiString(name);
        AccountInfo accountInfo = searchService.getAccountInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = searchService.getAllSummonerLeagueInfo(accountInfo.getId());
        SummonerDto summonerDto = summonerService.getSummonerDto(accountInfo, leagueInfos, API_INFO);
        return summonerDto;
    }

}
