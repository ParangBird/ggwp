package com.backend.ggwp.domain.game;

import com.backend.ggwp.domain.game.leagueitem.LeagueItemService;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;
import com.backend.ggwp.domain.game.match.MatchSummaryService;
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
import java.util.Optional;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ReactController {

    private final ApiInfo API_INFO;
    private final RestApiService restApiService;
    private final LeagueItemService leagueItemService;
    private final SummonerService summonerService;
    private final MatchSummaryService matchSummaryService;

    @GetMapping("/reactSearch/{name}")
    public SummonerDto index(@PathVariable(value = "name") String name) {
        String summonerName = StringFormat.setApiString(name);
        AccountInfo accountInfo = restApiService.getAccountInfo(summonerName);
        ArrayList<SummonerLeagueInfo> leagueInfos = restApiService.getAllSummonerLeagueInfo(accountInfo.getId());
        SummonerDto summonerDto = summonerService.getSummonerDto(accountInfo, leagueInfos, API_INFO);
        return summonerDto;
    }

    @GetMapping("/api/rankBySummonerName/{name}")
    public ArrayList<LeagueItem> rankBySummonerName(@PathVariable(value = "name") String name) {
        ArrayList<Optional<LeagueItem>> rank50 = leagueItemService.findRank50BySummonerName(name);
        return getLeagueItems(rank50);
    }

    private ArrayList<LeagueItem> getLeagueItems(ArrayList<Optional<LeagueItem>> rank50) {
        ArrayList<LeagueItem> returnRank50 = new ArrayList<>();
        for (int i = 0; i < rank50.size(); i++) {
            if (rank50.get(i).isPresent()) {
                //System.out.println("rank50.get(i) = " + rank50.get(i).get().getSummonerName());
                returnRank50.add(rank50.get(i).get());
            }
        }
        return returnRank50;
    }

    @GetMapping("/api/rank/{ranking}")
    public ArrayList<LeagueItem> rank(@PathVariable(value = "ranking") String ranking) {
        Long rank = Long.parseLong(ranking);
        ArrayList<Optional<LeagueItem>> rank50 = leagueItemService.findRank50(rank);
        return getLeagueItems(rank50);
    }


}
