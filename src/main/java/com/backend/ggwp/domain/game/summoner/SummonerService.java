package com.backend.ggwp.domain.game.summoner;

import com.backend.ggwp.domain.game.summoner.model.SummonerInfo;
import com.backend.ggwp.domain.game.summoner.model.LeagueEntrySummonerList;
import com.backend.ggwp.domain.game.summoner.model.SummonerInfoDTO;
import com.backend.ggwp.domain.game.summoner.model.SummonerLeagueInfo;
import com.backend.ggwp.utils.ApiInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

    public SummonerInfo getSummonerInfo(String summonerName) {
        String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), SummonerInfo.class);
    }

    public ArrayList<SummonerLeagueInfo> getAllSummonerLeagueInfo(String encryptedId) {
        String apiURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedId + "?api_key=" + API_INFO.getApiKey();
        StringBuffer result = restApi(apiURL);
        return new Gson().fromJson(result.toString(), new TypeToken<ArrayList<SummonerLeagueInfo>>() {
        }.getType());
    }

    public SummonerInfoDTO getSummonerInfoDTO(SummonerInfo summonerInfo, ArrayList<SummonerLeagueInfo> leagueInfos, ApiInfo apiInfo) {

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

        SummonerInfoDTO summonerInfoDto = SummonerInfoDTO.builder()
                .id(summonerInfo.getSummonerId())
                .name(summonerInfo.getName())
                .profileIconUrl("https://ddragon.leagueoflegends.com/cdn/" + apiInfo.getVersion() +
                        "/img/profileicon/" + summonerInfo.getProfileIconId() + ".png")
                .summonerLevel(summonerInfo.getSummonerLevel())
                .soloRank(soloRank)
                .flexRank(flexRank)
                .build();

        return summonerInfoDto;
    }

    public ArrayList<LeagueEntrySummonerList> getChallengerListSortedByScore() {

        ArrayList<ArrayList<LeagueEntrySummonerList>> challengerListAll = new ArrayList<>();

        int page = 1;
        while (true) {
            String apiURL = "https://kr.api.riotgames.com/lol/league-exp/v4/entries/RANKED_SOLO_5x5/CHALLENGER/I?page=" + page++ + "&api_key=" + API_INFO.getApiKey();
            StringBuffer result = restApi(apiURL);
            System.out.println("result = " + result);
            System.out.println("result.length() = " + result.length());
            if (result == null || result.length() == 0 || result.length() == 3) {
                break;
            }
            ArrayList<LeagueEntrySummonerList> challengerList = new Gson().fromJson(result.toString(), new TypeToken<ArrayList<LeagueEntrySummonerList>>() {
            }.getType());
            challengerListAll.add(challengerList);
        }

        ArrayList<LeagueEntrySummonerList> challengerList = new ArrayList<>();

        for (int i = 0; i < challengerListAll.size(); i++) {
            for (int j = 0; j < challengerListAll.get(i).size(); j++) {
                challengerList.add(challengerListAll.get(i).get(j));
            }
        }
        return challengerList;
    }
}
