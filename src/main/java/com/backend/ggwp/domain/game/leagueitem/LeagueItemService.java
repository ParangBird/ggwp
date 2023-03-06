package com.backend.ggwp.domain.game.leagueitem;

import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;
import com.backend.ggwp.domain.game.leagueitem.model.LeagueList;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
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

    public ArrayList<LeagueItem> getC2MList() {
        // 챌린저 ~ 마스터 정보 받아옴
        LeagueList challengerLeagueList = getChallengerList();
        LeagueList gmLeagueList = getGrandMasterList();
        LeagueList masterLeagueList = getMasterList();
        // 챌린저 ~ 마스터 각각 점수순 정렬
        ArrayList<LeagueItem> challengerList = challengerLeagueList.getEntries();
        ArrayList<LeagueItem> gmList = gmLeagueList.getEntries();
        ArrayList<LeagueItem> masterList = masterLeagueList.getEntries();

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
    public void updateAllV1(ArrayList<LeagueItem> challenger2MasterList) {
        clearAll();
        saveAll(challenger2MasterList);
    }

    @Transactional
    public void updateAllV2(ArrayList<LeagueItem> challenger2MasterList) {
        for (LeagueItem newItem : challenger2MasterList) {
            Optional<LeagueItem> byRanking = leagueItemRepository.findByRanking(newItem.getRanking());
            if (byRanking.isPresent()) {
                LeagueItem oldItem = byRanking.get();
                oldItem = newItem;
            } else {
                leagueItemRepository.save(newItem);
            }
        }
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
