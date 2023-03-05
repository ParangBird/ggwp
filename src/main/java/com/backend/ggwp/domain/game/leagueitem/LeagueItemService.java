package com.backend.ggwp.domain.game.leagueitem;

import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueList;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

import static com.backend.ggwp.utils.RestAPI.restApi;

@RequiredArgsConstructor
@Service
public class LeagueItemService {
    private final LeagueItemRepository leagueItemRepository;
    private final ApiInfo API_INFO;

    public ArrayList<Optional<LeagueItem>> findRank50BySummonerName(String summonerName) {
        ArrayList<Optional<LeagueItem>> leagueItems = new ArrayList<>();
        Long startRank = -1L;
        Optional<LeagueItem> leagueItem = leagueItemRepository.findBySummonerName(summonerName);
        if (leagueItem.isPresent())
            startRank = leagueItem.get().getId();
        if (startRank != -1L) {
            for (int i = 0; i < 50; i++) {
                Optional<LeagueItem> addLeagueItem = leagueItemRepository.findByRanking(startRank + i);
                if (addLeagueItem.isPresent())
                    leagueItems.add(addLeagueItem);
            }
        }
        return leagueItems;
    }


    public ArrayList<Optional<LeagueItem>> findRank50(Long startId) {
        ArrayList<Optional<LeagueItem>> leagueItems = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Optional<LeagueItem> leagueItem = leagueItemRepository.findByRanking(startId + i);
            if (leagueItem != null)
                leagueItems.add(leagueItem);
        }
        return leagueItems;
    }

    public LeagueList getChallengerList() {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        LeagueList challengerList = new Gson().fromJson(result.toString(), LeagueList.class);
        for (LeagueItem c : challengerList.getEntries())
            c.setSummonerRank("Challenger");
        return challengerList;
    }

    public LeagueList getGrandMasterList() {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        LeagueList grandMasterList = new Gson().fromJson(result.toString(), LeagueList.class);
        for (LeagueItem gm : grandMasterList.getEntries())
            gm.setSummonerRank("GrandMaster");
        return grandMasterList;
    }


    public LeagueList getMasterList() {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/masterleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        LeagueList masterList = new Gson().fromJson(result.toString(), LeagueList.class);
        for (LeagueItem m : masterList.getEntries())
            m.setSummonerRank("Master");
        return masterList;

    }


    @Transactional
    public void saveAll(ArrayList<LeagueItem> leagueItems) {
        for (LeagueItem leagueItem : leagueItems) {
            leagueItemRepository.save(leagueItem);
        }
    }

    @Transactional
    public void clearAll() {
        leagueItemRepository.deleteAllInBatch();
    }
}
