package com.backend.ggwp.domain.game.currentgame;

import com.backend.ggwp.domain.game.currentgame.model.CurrentGameInfo;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.backend.ggwp.utils.RestAPI.restApi;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrentGameService {
    private final ApiInfo API_INFO;
    public CurrentGameInfo getCurrentGame(String encryptedId) {
        String apiURL = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + encryptedId + "?api_key=" + API_INFO.getApiKey();
        //System.out.println("apiURL = " + apiURL);
        String result = restApi(apiURL);
        //System.out.println("result = " + result);
        CurrentGameInfo currentGameInfo = new Gson().fromJson(result, CurrentGameInfo.class);
        return currentGameInfo;
    }
}
