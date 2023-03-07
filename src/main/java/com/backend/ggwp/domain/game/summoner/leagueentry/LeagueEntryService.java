package com.backend.ggwp.domain.game.summoner.leagueentry;

import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.backend.ggwp.utils.RestAPI.restApi;

@RequiredArgsConstructor
@Service
public class LeagueEntryService {
    private final ApiInfo API_INFO;

    public ArrayList<LeagueEntry> getChallengerListSortedByScore() {
        ArrayList<ArrayList<LeagueEntry>> challengerListAll = new ArrayList<>();

        int page = 1;
        while (true) {
            String apiURL = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=" + page++ + "&api_key=" + API_INFO.getApiKey();
            StringBuffer result = restApi(apiURL);
            System.out.println("result = " + result);
            System.out.println("result.length() = " + result.length());
            if (result == null || result.length() == 0 || result.length() == 3) {
                break;
            }
            ArrayList<LeagueEntry> challengerList = new Gson().fromJson(result.toString(), new TypeToken<ArrayList<LeagueEntry>>() {
            }.getType());
            challengerListAll.add(challengerList);
        }

        ArrayList<LeagueEntry> challengerList = new ArrayList<>();

        for (int i = 0; i < challengerListAll.size(); i++) {
            for (int j = 0; j < challengerListAll.get(i).size(); j++) {
                challengerList.add(challengerListAll.get(i).get(j));
            }
        }
        return challengerList;
    }
}
