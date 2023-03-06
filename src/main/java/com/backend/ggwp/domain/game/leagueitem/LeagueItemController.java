package com.backend.ggwp.domain.game.leagueitem;

import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class LeagueItemController {

    private final LeagueItemService leagueItemService;

    @GetMapping("/api/rankinfo")
    public ArrayList<LeagueItem> getC2MInfo() {
        // 각각 정렬한 친구들을 챌-그마-마 순서로 합침
        ArrayList<LeagueItem> challenger2MasterList = leagueItemService.getC2MList();
        leagueItemService.updateAllV1(challenger2MasterList);
        return challenger2MasterList;
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
