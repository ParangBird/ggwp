package com.backend.ggwp.domain.game.summoner.summonerleagueinfo;

import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.backend.ggwp.utils.RestAPI.riotRestAPI;

@RequiredArgsConstructor
@Service
public class SummonerLeagueInfoService {
    private final ApiInfo API_INFO;

    public ArrayList<SummonerLeagueInfo> getAllSummonerLeagueInfo(String encryptedId) {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedId + "?api_key=" + API_INFO.getApiKey();
        String result = riotRestAPI(apiURL);
        return new Gson().fromJson(result, new TypeToken<ArrayList<SummonerLeagueInfo>>() {
        }.getType());
    }
}
