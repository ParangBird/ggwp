package com.backend.ggwp.controller;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.Dto.SummonerDto;
import com.backend.ggwp.domain.entity.SummonerLeagueInfo;
import com.backend.ggwp.domain.entity.common.StringFormat;
import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.service.LeagueItemService;
import com.backend.ggwp.service.RestApiService;
import com.backend.ggwp.service.SummonerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;


@Slf4j
@RestController
public class ReactController {

    private final ApiInfo API_INFO;
    private final RestApiService restApiService;
    private final LeagueItemService leagueItemService;

    @Autowired
    private SummonerService summonerService;

    public ReactController(ApiInfo api_info, RestApiService restApiService, LeagueItemService leagueItemService) {
        API_INFO = api_info;
        this.restApiService = restApiService;
        this.leagueItemService = leagueItemService;
    }

    @GetMapping("/reactSearch/{name}")
    public SummonerDto index(@PathVariable(value = "name")String name){
        String summonerName = StringFormat.setApiString(name);

        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = restApiService.getAllSummonerLeagueInfo(accountInfo.getId());

        SummonerDto summonerDto = summonerService.getSummonerDto(accountInfo, leagueInfos, API_INFO);
        return summonerDto;
    }

    @GetMapping("/api/rank/{ranking}")
    public ArrayList<LeagueItem> rank(@PathVariable(value = "ranking")String ranking){
        Long rank = Long.parseLong(ranking);
        ArrayList<Optional<LeagueItem>> rank50 = leagueItemService.findRank50(rank);
        ArrayList<LeagueItem> returnRank50 = new ArrayList<>();
        for(int i=0;i<rank50.size();i++){
            if(rank50.get(i).isPresent()) {
                //System.out.println("rank50.get(i) = " + rank50.get(i).get().getSummonerName());
                returnRank50.add(rank50.get(i).get());
            }
        }
        return returnRank50;
    }

}
