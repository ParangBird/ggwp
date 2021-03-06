package com.backend.ggwp.controller;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.domain.Dto.MatchDto;
import com.backend.ggwp.domain.entity.AccountInfo;
import com.backend.ggwp.domain.Dto.SummonerDto;
import com.backend.ggwp.domain.entity.SummonerLeagueInfo;
import com.backend.ggwp.domain.entity.common.StringFormat;
import com.backend.ggwp.domain.entity.leagueList.LeagueItem;
import com.backend.ggwp.domain.entity.match.Match;
import com.backend.ggwp.domain.entity.match.Participant;
import com.backend.ggwp.domain.entity.record.MatchSummary;
import com.backend.ggwp.domain.entity.user.User;
import com.backend.ggwp.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private UserService userService;

    @Autowired
    private SummonerService summonerService;

    @Autowired
    private MatchApiService matchApiService;

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

    //?????? ??????
    @GetMapping("/api/matches/update/{name}")
    public void updateMatches(@PathVariable(value = "name")String name){
        String summonerName = StringFormat.setApiString(name);
        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        matchApiService.updateMatchSummary(accountInfo);
    }

    //????????? ????????? ?????? ?????? ???????????? ??????
    //????????? ????????? ????????? ???????????? ???????????? ??????????????? ?????? ??????
    //??????, ??????, ????????? ??? ????????? ???????????? ???????????? ??????????????????
    //???????????? ????????? ????????? ????????? ?????? ????????? ?????? ????????? ???????????? ???????????? ?????? ?????? ???????????? ????????????
    @GetMapping("/api/matches/{name}")
    public ArrayList<MatchSummary> getMatches(@PathVariable(value = "name")String name){
        String summonerName = StringFormat.setApiString(name);
        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        ArrayList<MatchSummary> matchSummaries = matchApiService.getAll30Matches(accountInfo);
        return matchSummaries;
    }

    @GetMapping("/api/matches/{name}/solo")
    public ArrayList<MatchSummary> getSoloMatches(@PathVariable(value = "name")String name){
        String summonerName = StringFormat.setApiString(name);
        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        ArrayList<MatchSummary> matchSummaries = matchApiService.get30SoloRankMatches(accountInfo);
        return matchSummaries;
    }

    @GetMapping("/api/rankBySummonerName/{name}")
    public ArrayList<LeagueItem> rankBySummonerName(@PathVariable(value = "name")String name){
        ArrayList<Optional<LeagueItem>> rank50 = leagueItemService.findRank50BySummonerName(name);
        return getLeagueItems(rank50);
    }

    private ArrayList<LeagueItem> getLeagueItems(ArrayList<Optional<LeagueItem>> rank50) {
        ArrayList<LeagueItem> returnRank50 = new ArrayList<>();
        for(int i=0;i<rank50.size();i++){
            if(rank50.get(i).isPresent()) {
                //System.out.println("rank50.get(i) = " + rank50.get(i).get().getSummonerName());
                returnRank50.add(rank50.get(i).get());
            }
        }
        return returnRank50;
    }

    @GetMapping("/api/rank/{ranking}")
    public ArrayList<LeagueItem> rank(@PathVariable(value = "ranking")String ranking){
        Long rank = Long.parseLong(ranking);
        ArrayList<Optional<LeagueItem>> rank50 = leagueItemService.findRank50(rank);
        return getLeagueItems(rank50);
    }


    @PostMapping("/api/user/register")
    public void register(User user){
         if(userService.findByUserName(user.getUserName()) != null)
            userService.save(user);
    }

}
