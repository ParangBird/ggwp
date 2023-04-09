package com.backend.ggwp.domain.game.leagueitem;

import com.backend.ggwp.aop.LogExecutionTime;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueList;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static com.backend.ggwp.utils.RestAPI.riotRestAPI;

@Slf4j
@RequiredArgsConstructor
@Service
public class LeagueItemService {
    private final LeagueItemRepository leagueItemRepository;
    private final ApiInfo API_INFO;
    private final Gson gson;

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

    @LogExecutionTime
    public ArrayList<LeagueItem> getC2MList() {
        ArrayList<LeagueItem> challengerList = getChallengerList();
        ArrayList<LeagueItem> gmList = getGrandMasterList();
        ArrayList<LeagueItem> masterList = getMasterList();

        ArrayList<LeagueItem> challenger2MasterList = new ArrayList<>();
        for (LeagueItem c : challengerList)
            challenger2MasterList.add(c);
        for (LeagueItem gm : gmList)
            challenger2MasterList.add(gm);
        for (LeagueItem m : masterList)
            challenger2MasterList.add(m);

        Collections.sort(challenger2MasterList, new LeagueItemComparator());

        for (long i = 0; i < challenger2MasterList.size(); i++) {
            challenger2MasterList.get((int) i).setRanking(i + 1);
        }
        return challenger2MasterList;

    }

    public ArrayList<LeagueItem> getChallengerList() {
        LeagueList challengerList = getChallengerLeague();
        return challengerList.getEntries();
    }

    public ArrayList<LeagueItem> getGrandMasterList() {
        LeagueList grandMasterList = getGrandMasterLeague();
        return grandMasterList.getEntries();
    }

    public ArrayList<LeagueItem> getMasterList() {
        LeagueList masterList = getMasterLeague();
        return masterList.getEntries();
    }

    public LeagueList getChallengerLeague() {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        String result = riotRestAPI(apiURL);
        LeagueList challengerList = gson.fromJson(result, LeagueList.class);
        for (LeagueItem c : challengerList.getEntries())
            c.setSummonerRank("Challenger");
        return challengerList;
    }

    public LeagueList getGrandMasterLeague() {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        String result = riotRestAPI(apiURL);
        LeagueList grandMasterList = gson.fromJson(result, LeagueList.class);
        for (LeagueItem gm : grandMasterList.getEntries())
            gm.setSummonerRank("GrandMaster");
        return grandMasterList;
    }


    public LeagueList getMasterLeague() {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/masterleagues/by-queue/RANKED_SOLO_5x5?api_key=" + API_INFO.getApiKey();
        String result = riotRestAPI(apiURL);
        LeagueList masterList = gson.fromJson(result, LeagueList.class);
        for (LeagueItem m : masterList.getEntries())
            m.setSummonerRank("Master");
        return masterList;

    }

    @Transactional
    public void updateAll(ArrayList<LeagueItem> challenger2MasterList) {
        clearAll();
        saveAll(challenger2MasterList);
    }

    @Transactional
    public void saveAll(ArrayList<LeagueItem> leagueItems) {
        leagueItemRepository.saveAll(leagueItems);
    }

    @Transactional
    public void clearAll() {
        leagueItemRepository.deleteAllInBatch();
    }
}
