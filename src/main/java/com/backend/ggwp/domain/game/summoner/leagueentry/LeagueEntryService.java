package com.backend.ggwp.domain.game.summoner.leagueentry;

import com.backend.ggwp.aop.LogExecutionTime;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.backend.ggwp.utils.RestAPI.riotRestAPI;

@Slf4j
@RequiredArgsConstructor
@Service
public class LeagueEntryService {
    private final ApiInfo API_INFO;
    private final LeagueEntryRepository leagueEntryRepository;
    private final Gson gson;
    //    RATE LIMITS
    //  20 requests every 1 seconds(s)
    //  100 requests every 2 minutes(s)
    //  1 request for 1.5 sec


    @LogExecutionTime
    @Transactional
    public ArrayList<LeagueEntry> getChallengerLeagueEntry() throws InterruptedException {
        ArrayList<LeagueEntry> challengerListAll = new ArrayList<>();
        int page = 1;
        while (true) {
            Thread.sleep(1500);
            String apiURL = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=" + page++ + "&api_key=" + API_INFO.getApiKey();
            String result = riotRestAPI(apiURL);
            log.info(result);
            if (result == null || result.length() <= 3) {
                break;
            }
            ArrayList<LeagueEntry> challengerList =
                    gson.fromJson(result, new TypeToken<ArrayList<LeagueEntry>>() {
                    }.getType());
            for (LeagueEntry leagueEntry : challengerList) {
                leagueEntryRepository.findBySummonerId(leagueEntry.getSummonerId()).ifPresent((prev) -> {
                    leagueEntry.setId(prev.getId());
                });
                challengerListAll.add(leagueEntry);
            }
        }
        leagueEntryRepository.saveAll(challengerListAll);
        return challengerListAll;
    }

    @LogExecutionTime
    @Transactional
    public ArrayList<LeagueEntry> getTierLeagueEntry(String tier, String rank) throws InterruptedException {
        ArrayList<LeagueEntry> tierLeagueEntryList = new ArrayList<>();
        int page = 1;
        while (true) {
            Thread.sleep(1500);
            String apiURL = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/" +
                    tier + "/" + rank + "?page=" + page++ + "&api_key=" + API_INFO.getApiKey();
            String result = riotRestAPI(apiURL);
            if (result == null || result.length() <= 3) {
                break;
            }
            ArrayList<LeagueEntry> leagueEntries =
                    gson.fromJson(result, new TypeToken<ArrayList<LeagueEntry>>() {
                    }.getType());
            for (LeagueEntry leagueEntry : leagueEntries) {
                leagueEntryRepository.findBySummonerId(leagueEntry.getSummonerId()).ifPresent((prev) -> {
                    leagueEntry.setId(prev.getId());
                });
            }
            tierLeagueEntryList.addAll(leagueEntries);
        }
        leagueEntryRepository.saveAll(tierLeagueEntryList);
        log.info("tier size {}", tierLeagueEntryList.size());
        return tierLeagueEntryList;
    }
}
