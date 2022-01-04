package com.backend.ggwp.controller;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.entity.SummonerDto;
import com.backend.ggwp.domain.entity.SummonerLeagueInfo;
import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.service.LeagueItemService;
import com.backend.ggwp.service.RestApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ReactController {

    private final ApiInfo API_INFO;
    private final RestApiService restApiService;
    private final LeagueItemService leagueItemService;

    public ReactController(ApiInfo api_info, RestApiService restApiService, LeagueItemService leagueItemService) {
        API_INFO = api_info;
        this.restApiService = restApiService;
        this.leagueItemService = leagueItemService;
    }

    @GetMapping("/reactSearch/{name}")
    public SummonerDto index(@PathVariable(value = "name")String name){
        String summonerName = name;
        if(summonerName.length() == 2) summonerName = summonerName.charAt(0) + " " + summonerName.charAt(1);
        summonerName = summonerName.replace(" ","+");

        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);

        if(accountInfo.getId() == null)
            return null;

        String encryptedId = accountInfo.getId();
        ArrayList<SummonerLeagueInfo> summoner = restApiService.getAllSummonerLeagueInfo(encryptedId);

        SummonerLeagueInfo soloQueue = null;
        for(int i=0;i<summoner.size();i++){
            System.out.println(summoner.get(i).getQueueType());
            if(summoner.get(i).getQueueType().equals("RANKED_SOLO_5x5"))
                soloQueue = summoner.get(i);
        }

        if(soloQueue == null)
            return null;

        SummonerDto summonerDto = new SummonerDto();
        summonerDto.setId(accountInfo.getId());
        summonerDto.setProfileIconId(accountInfo.getProfileIconId());
        summonerDto.setProfileIconUrl("https://ddragon.leagueoflegends.com/cdn/"+API_INFO.getVersion()+"/img/profileicon/"+ accountInfo.getProfileIconId() +".png");
        summonerDto.setSummonerLevel(accountInfo.getSummonerLevel());

        return summonerDto;
    }

    @GetMapping("/rank/{ranking}")
    public List<LeagueItem> rank(@PathVariable(value = "ranking")String ranking){
        Long rank = Long.parseLong(ranking);
        ArrayList<Optional<LeagueItem>> rank50 = leagueItemService.findRank50(rank);
        for(int i=0;i<rank50.size();i++){
            if(rank50.get(i) != null) {
                System.out.println("rank50.get(i) = " + rank50.get(i).get().getSummonerName());
            }
        }
        return null;
    }

}
