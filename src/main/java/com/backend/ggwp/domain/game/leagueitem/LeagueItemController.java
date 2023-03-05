package com.backend.ggwp.domain.game.leagueitem;

import com.backend.ggwp.domain.game.search.SearchService;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class LeagueItemController {

    private final SearchService searchService;
    private final LeagueItemService leagueItemService;

    @GetMapping("/api/rankinfo")
    public ArrayList<LeagueItem> getC2MInfo() {
        // 챌린저 ~ 마스터 정보 받아옴
        LeagueList challengerLeagueList = searchService.getChallengerList();
        LeagueList gmLeagueList = searchService.getGrandMasterList();
        LeagueList masterLeagueList = searchService.getMasterList();

        // 챌린저 ~ 마스터 각각 점수순 정렬
        ArrayList<LeagueItem> challengerList = challengerLeagueList.getEntries();
        Collections.sort(challengerList, new LeagueItemComparator());
        ArrayList<LeagueItem> gmList = gmLeagueList.getEntries();
        Collections.sort(gmList, new LeagueItemComparator());
        ArrayList<LeagueItem> masterList = masterLeagueList.getEntries();
        Collections.sort(masterList, new LeagueItemComparator());

        // 각각 정렬한 친구들을 챌-그마-마 순서로 합침
        ArrayList<LeagueItem> challenger2MasterList = new ArrayList<>();
        for (LeagueItem c : challengerList)
            challenger2MasterList.add(c);
        for (LeagueItem gm : gmList)
            challenger2MasterList.add(gm);
        for (LeagueItem m : masterList)
            challenger2MasterList.add(m);

        for (long i = 0; i < challenger2MasterList.size(); i++) {
            challenger2MasterList.get((int) i).setRanking(i + 1);
        }

        leagueItemService.clearAll();
        leagueItemService.saveAll(challenger2MasterList);
        return (challenger2MasterList);
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
