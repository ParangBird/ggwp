package com.backend.ggwp.domain.game.summoner;

import com.backend.ggwp.domain.game.summoner.model.AccountInfo;
import com.backend.ggwp.domain.game.summoner.model.SummonerDto;
import com.backend.ggwp.domain.game.summoner.model.SummonerLeagueInfo;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.backend.ggwp.utils.RestAPI.restApi;

@Slf4j
@Service
@RequiredArgsConstructor
public class SummonerService {

    private final ApiInfo API_INFO;

    public AccountInfo getAccountInfo(String summonerName) {
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), AccountInfo.class);
    }

    public SummonerDto getSummonerDto(AccountInfo accountInfo, ArrayList<SummonerLeagueInfo> leagueInfos, ApiInfo apiInfo) {

        SummonerLeagueInfo soloRank = new SummonerLeagueInfo();
        SummonerLeagueInfo flexRank = new SummonerLeagueInfo();

        for (SummonerLeagueInfo s : leagueInfos) {
            if (s.getQueueType().equals("RANKED_SOLO_5x5")) {
                soloRank = s;
                log.info(soloRank.getQueueType());
            } else if (s.getQueueType().equals("RANKED_FLEX_SR")) {
                flexRank = s;
                log.info(flexRank.getQueueType());
            }
        }

        SummonerDto summonerDto = SummonerDto.builder()
                .id(accountInfo.getId())
                .name(accountInfo.getName())
                .profileIconUrl("https://ddragon.leagueoflegends.com/cdn/" + apiInfo.getVersion() +
                        "/img/profileicon/" + accountInfo.getProfileIconId() + ".png")
                .summonerLevel(accountInfo.getSummonerLevel())
                .soloRank(soloRank)
                .flexRank(flexRank)
                .build();

        return summonerDto;
    }
}
