package com.backend.ggwp.controller;

import com.backend.ggwp.config.ApiInfo;
import com.backend.ggwp.domain.AccountInfo;
import com.backend.ggwp.domain.leagueitem.LeagueItemService;
import com.backend.ggwp.domain.record.MatchApiService;
import com.backend.ggwp.domain.summoner.SummonerDto;
import com.backend.ggwp.domain.SummonerLeagueInfo;
import com.backend.ggwp.domain.summoner.SummonerService;
import com.backend.ggwp.utils.StringFormat;
import com.backend.ggwp.domain.leagueitem.LeagueItem;
import com.backend.ggwp.domain.record.MatchSummary;
import com.backend.ggwp.domain.user.GgwpUser;
import com.backend.ggwp.domain.user.UserService;
import com.backend.ggwp.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Optional;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ReactController {

    private final ApiInfo API_INFO;
    private final RestApiService restApiService;
    private final LeagueItemService leagueItemService;
    private final UserService userService;
    private final SummonerService summonerService;
    private final MatchApiService matchApiService;

    @GetMapping("/reactSearch/{name}")
    public SummonerDto index(@PathVariable(value = "name")String name){
        String summonerName = StringFormat.setApiString(name);

        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = restApiService.getAllSummonerLeagueInfo(accountInfo.getId());

        SummonerDto summonerDto = summonerService.getSummonerDto(accountInfo, leagueInfos, API_INFO);
        return summonerDto;
    }

    //전적 갱신
    @GetMapping("/api/matches/update/{name}")
    public void updateMatches(@PathVariable(value = "name")String name) throws UnsupportedEncodingException {
        String summonerName = StringFormat.setApiString(name);
        String encodedName = URLEncoder.encode(summonerName, "UTF-8");
        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        //log.info(accountInfo.toString());
        matchApiService.updateMatchSummary(accountInfo);
    }

    //디비에 저장된 전적 정보 가져와서 반환
    //추가로 저장된 전적이 부족하면 자동으로 갱신하도록 변경 예정
    //솔랭, 일반, 자유랭 등 큐타입 선택해서 받는것도 추가해야할듯
    //전적검색 속도는 충분히 빠른것 같고 추가로 해당 전적의 상세정보 받아오는 것은 이전 방식으로 진행할것
    @GetMapping("/api/matches/{name}")
    public ArrayList<MatchSummary> getMatches(@PathVariable(value = "name")String name) throws UnsupportedEncodingException {
        String summonerName = StringFormat.setApiString(name);
        String encodedName = URLEncoder.encode(summonerName, "UTF-8");
        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        ArrayList<MatchSummary> matchSummaries = matchApiService.getAll30Matches(accountInfo);
        //log.info(matchSummaries.get(0).toString());
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
    public void register(GgwpUser ggwpUser){
         if(userService.findByName(ggwpUser.getName()) != null)
            userService.save(ggwpUser);
    }

}
