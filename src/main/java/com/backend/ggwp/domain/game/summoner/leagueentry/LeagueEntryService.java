package com.backend.ggwp.domain.game.summoner.leagueentry;

import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.backend.ggwp.utils.RestAPI.restApi;

@RequiredArgsConstructor
@Service
public class LeagueEntryService {
    private final ApiInfo API_INFO;
    private final LeagueEntryRepository leagueEntryRepository;
    //    RATE LIMITS
    //  20 requests every 1 seconds(s)
    //  100 requests every 2 minutes(s)
    //  1 request for 1.5 sec


    @Transactional
    public ArrayList<LeagueEntry> getChallengerLeagueEntry() throws InterruptedException {
        ArrayList<LeagueEntry> challengerListAll = new ArrayList<>();
        int page = 1;
        while (true) {
            Thread.sleep(1500);
            String apiURL = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=" + page++ + "&api_key=" + API_INFO.getApiKey();
            StringBuffer result = restApi(apiURL);
            if (result == null || result.length() == 0 || result.length() == 3) {
                break;
            }
            ArrayList<LeagueEntry> challengerList =
                    new Gson().fromJson(result.toString(), new TypeToken<ArrayList<LeagueEntry>>() {
                    }.getType());
            for (LeagueEntry leagueEntry : challengerList) {
                challengerListAll.add(leagueEntry);
            }
        }
        leagueEntryRepository.saveAll(challengerListAll);
        return challengerListAll;
    }
}
